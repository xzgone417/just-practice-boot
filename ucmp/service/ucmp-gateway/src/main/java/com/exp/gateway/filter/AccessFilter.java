package com.exp.gateway.filter;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;

import com.egrid.cache.jedis.cache.RedisCache;
import com.egrid.core.json.pool.Type;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.gateway.constant.GatewayConstants;
import com.exp.gateway.consumer.AuthConsumer;
import com.exp.gateway.interceptor.FeignInterceptor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.netflix.client.ClientFactory;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.IClientConfig;
import com.netflix.client.config.IClientConfigKey;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.LBClient;
import feign.ribbon.LBClientFactory;
import feign.ribbon.RibbonClient;
import reactor.core.publisher.Mono;

public class AccessFilter extends AbstractFilter implements GlobalFilter, Ordered {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

	@Autowired
	private RedisCache shiroRedisCache;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public int getOrder() {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String tmpToken = exchange.getRequest().getHeaders()
				.getFirst(GatewayConstants.gatewayProperties.getSaveToHeader());
		String authorizedUrl = getPathWithinApplication(exchange);
		LOGGER.info(String.format("ReqID[%s] %s AccessFilter request to %s, scheme is %s, authorized url is %s, userToken is %s",
				exchange.getRequest().getId(), exchange.getRequest().getMethod(), exchange.getRequest().getURI(),
				exchange.getRequest().getURI().getScheme(), authorizedUrl, tmpToken));
		String scheme = exchange.getRequest().getURI().getScheme();
		if (isWebSocketExchange(scheme, authorizedUrl)) {
			/**
			 * Websocket的处理，Websocket不认证、不鉴权
			 */
			if (GatewayConstants.gatewayProperties.getWebsocketInfoUrl().equals(authorizedUrl)) {
				String wsScheme = convertWsToHttp(scheme);
				URI wsRequestUrl = UriComponentsBuilder.fromUri(exchange.getRequest().getURI()).scheme(wsScheme).build()
						.toUri();
				exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, wsRequestUrl);
			}
			return chain.filter(exchange).then(Mono.defer(() -> {
				exchange.getResponse().getHeaders().entrySet().stream()
						.filter(kv -> (kv.getValue() != null && kv.getValue().size() > 1))
						.filter(kv -> (kv.getKey().equals(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN)
								|| kv.getKey().equals(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS)))
						.forEach(kv -> {
							kv.setValue(new ArrayList<String>() {
								{
									add(kv.getValue().get(0));
								}
							});
						});
				return chain.filter(exchange);
			}));
		} else {
			Map<String, Object> user = null;
			try {
				String token = exchange.getRequest().getHeaders()
						.getFirst(GatewayConstants.gatewayProperties.getSaveToHeader());
				if (!shouldAuthenticateFilter(authorizedUrl)) {
					/*无需认证即可使用*/
					String strUser = null;
					if (!StringUtil.isEmpty(token)) {
						strUser = (String) shiroRedisCache
								.get(GatewayConstants.gatewayProperties.getUserKey() + ":" + token);
					}
					
					if (StringUtil.isEmpty(strUser)) {
						return chain.filter(exchange);
					} else {
						user = JsonBeanUtil.jsonToBean(strUser, HashMap.class);
						return userResponse(token, user, exchange, chain);
					}
				} else {
					/*需要认证才允许使用*/
					if (!shouldAuthorizedFilter(authorizedUrl)) {
						/*无需鉴权(只要登录就能访问)*/
						String strUser = null;
						if (!StringUtil.isEmpty(token)) {
							strUser = (String) shiroRedisCache
									.get(GatewayConstants.gatewayProperties.getUserKey() + ":" + token);
						}
						if (StringUtil.isEmpty(strUser)) {
							// 免鉴权，表示还是需要认证的，如果缓存里没有，表示需要用户再次登录
							return badResponse(exchange, HttpStatus.UNAUTHORIZED, RestStatusCode.SESSION_TIMEOUT,
									new Exception("登录已失效，请重新登录"));
						} else {
							user = JsonBeanUtil.jsonToBean(strUser, HashMap.class);
							return userResponse(token, user, exchange, chain);
						}
					} else {
						/*需要鉴权*/
						Long startTime = new Date().getTime();
						/** 获取service-auth服务在注册中心注册的地址 */
						StringBuffer listOfServers = new StringBuffer();
						List<ServiceInstance> serviceInstances = discoveryClient
								.getInstances(GatewayConstants.gatewayProperties.getAuthService());
						for (ServiceInstance instance : serviceInstances) {
							listOfServers.append(instance.getHost()).append(":").append(instance.getPort()).append(",");
						}

						/** 通过Feign调用远程服务，获取认证信息 */
						RibbonClient client = RibbonClient.builder().lbClientFactory(new LBClientFactory() {
							@Override
							public LBClient create(String clientName) {
								IClientConfig config = ClientFactory.getNamedConfig(clientName);
								IClientConfigKey<String> key = CommonClientConfigKey.ListOfServers;
								config.set(key, listOfServers.substring(0, listOfServers.length() - 1));
								ILoadBalancer lb = ClientFactory.getNamedLoadBalancer(clientName);
								@SuppressWarnings("rawtypes")
								ZoneAwareLoadBalancer zb = (ZoneAwareLoadBalancer) lb;
								zb.setRule(new RandomRule());
								return LBClient.create(lb, config);
							}
						}).build();

						/**
						 * Request里已经存在的Header内容
						 */
						String[] arySaveToHeader;
						if (StringUtil.isEmpty(GatewayConstants.gatewayProperties.getSaveToHeader())) {
							arySaveToHeader = new String[] {};
						} else {
							if (GatewayConstants.gatewayProperties.getSaveToHeader().indexOf(",") > 0) {
								arySaveToHeader = GatewayConstants.gatewayProperties.getSaveToHeader().split(",");
							} else {
								arySaveToHeader = GatewayConstants.gatewayProperties.getSaveToHeader().split(" ");
							}
							for (int i = 0; i < arySaveToHeader.length; i++) {
								arySaveToHeader[i] = arySaveToHeader[i].trim();
							}
						}

						/**
						 * 追加的Header内容
						 */
						Map<String, String> addHeader = new HashMap<>();
						addHeader.put(GatewayConstants.gatewayProperties.getFilterUrlStorage(), authorizedUrl);
						AuthConsumer service = Feign.builder()
								.requestInterceptor(new FeignInterceptor(exchange.getRequest(), arySaveToHeader, addHeader))
								.client(client).encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
								.target(AuthConsumer.class,
										"http://" + GatewayConstants.gatewayProperties.getAuthService());
						RestResponse<Map<String, Object>> restResponse = service.isPermitted();

						LOGGER.info(String.format("ReqID[%s] Authorization URL is %s, Time is %s, Result is %s",
								exchange.getRequest().getId(), authorizedUrl, (new Date().getTime() - startTime), (restResponse != null ? restResponse.getCode() : "NULL")));
						if (restResponse == null) {
							return badResponse(exchange, HttpStatus.BAD_REQUEST, RestStatusCode.SERVER_UNKNOWN_ERROR,
									new Exception(RestStatusCode.SERVER_UNKNOWN_ERROR.message()));
						} else {
							if (restResponse.getCode() == RestStatusCode.OK.code()) {
								Map<String, Object> loginResult = restResponse.getResult();
								if (loginResult.get("user") instanceof String) {
									user = JsonBeanUtil.jsonToBean((String)loginResult.get("user"), new Type(new TypeReference<Map<String, Object>>(){
							    	})) ;
								} else {
									user = (Map<String, Object>) loginResult.get("user");
								}
								if (user.get("partyId") != null) {
									return userResponse(token, user, exchange, chain);
								} else {
									// 如果鉴权的接口未返回用户信息，表示用户未登录，此地非免认证的入口，则表示需要认证才能请求接口
									if (StringUtil.isEmpty(token)) {
										return badResponse(exchange, HttpStatus.UNAUTHORIZED, RestStatusCode.UNAUTHENTICED,
												new Exception("尚未登录，请登录"));
									} else {
										return badResponse(exchange, HttpStatus.UNAUTHORIZED, RestStatusCode.SESSION_TIMEOUT,
												new Exception("登录已失效，请重新登录"));
									}
								}
							}
							if (restResponse.getCode() == RestStatusCode.UNAUTHENTICED.code()) {
								return badResponse(exchange, HttpStatus.UNAUTHORIZED, RestStatusCode.UNAUTHENTICED,
										new Exception("尚未登录，请登录"));
							}
							if (restResponse.getCode() == RestStatusCode.SESSION_TIMEOUT.code()) {
								return badResponse(exchange, HttpStatus.UNAUTHORIZED, RestStatusCode.SESSION_TIMEOUT,
										new Exception("登录已失效，请重新登录"));
							}
							if (restResponse.getCode() == RestStatusCode.UNAUTHORIZED.code()) {
								return badResponse(exchange, HttpStatus.UNAUTHORIZED, RestStatusCode.UNAUTHORIZED,
										new Exception("没有权限操作该功能，请确认"));
							}
							if (restResponse.getCode() == RestStatusCode.SERVER_UNKNOWN_ERROR.code()) {
								return badResponse(exchange, HttpStatus.BAD_REQUEST, RestStatusCode.SERVER_UNKNOWN_ERROR,
										new Exception(RestStatusCode.SERVER_UNKNOWN_ERROR.message()));
							} else {
								return badResponse(exchange, HttpStatus.BAD_REQUEST, RestStatusCode.SERVER_UNKNOWN_ERROR,
										new Exception(RestStatusCode.SERVER_UNKNOWN_ERROR.message()));
							}
						}
					}
				} 
			} finally {

			}
		}
	}

	private Mono<Void> userResponse(String token, Map<String, Object> user, ServerWebExchange exchange,
			GatewayFilterChain chain) {
		try {
			user.put("realIp", getRequestIp(exchange.getRequest()));
			user.put("token", token);
			ServerHttpRequest request = addHeader(exchange.getRequest(),
					GatewayConstants.gatewayProperties.getUserKey(),
					URLEncoder.encode(JsonBeanUtil.beanToJson(user), "UTF-8"));
			return chain.filter(exchange.mutate().request(request).build());
		} catch (UnsupportedEncodingException e) {
			return badResponse(exchange, HttpStatus.BAD_REQUEST, RestStatusCode.SERVER_UNKNOWN_ERROR,
					new Exception(RestStatusCode.SERVER_UNKNOWN_ERROR.message()));
		} finally {
			if (!StringUtil.isEmpty(token)) {
				shiroRedisCache.expire(GatewayConstants.gatewayProperties.getUserKey() + ":" + token, TimeUnit.SECONDS,
						shiroRedisCache.getExpireSeconds());
				shiroRedisCache.expire(token, TimeUnit.SECONDS, shiroRedisCache.getExpireSeconds());
			}
		}
	}

}
