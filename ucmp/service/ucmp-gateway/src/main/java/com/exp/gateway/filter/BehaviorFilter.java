package com.exp.gateway.filter;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.ServerWebExchange;

import com.egrid.cache.jedis.cache.RedisCache;
import com.egrid.core.threadlocal.pool.TtlExecutors;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.exp.gateway.constant.GatewayConstants;
import com.exp.gateway.consumer.BehaviorConsumer;
import com.exp.gateway.consumer.BehaviorConsumer.BehaviorDto;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BehaviorFilter extends AbstractFilter implements Ordered, GlobalFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(BehaviorFilter.class);
	@Autowired
	private RedisCache shiroRedisCache;

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String url = getPathWithinApplication(exchange);
		if (GatewayConstants.gatewayProperties.getBehaviorSwitch() && shouldBehaviorFilter(url)) {
			if (!StringUtil.isEmpty(GatewayConstants.gatewayProperties.getBehaviorService())) {
				LOGGER.info(String.format("ReqID[%s] %s BehaviorFilter request to %s, scheme is %s, behavior url is %s",
						exchange.getRequest().getId(), exchange.getRequest().getMethod(), exchange.getRequest().getURI(),
						exchange.getRequest().getURI().getScheme(), url));
				/*登记请求的记录*/
				BehaviorDto dto = new BehaviorDto();
				try {
					dto.setPartyId(getUserId(exchange));
					dto.setRequestId(exchange.getRequest().getId());
					dto.setBehaviorTargetUrl(url);
					dto.setQueryParams(exchange.getRequest().getQueryParams().toString());
					MediaType mediaType = exchange.getRequest().getHeaders().getContentType();
					if (HttpMethod.POST.name().equalsIgnoreCase(exchange.getRequest().getMethodValue())) {
						if (mediaType == null || !(mediaType.equals(MediaType.MULTIPART_FORM_DATA)
								|| mediaType.equals(MediaType.MULTIPART_MIXED) || mediaType.equals(MediaType.MULTIPART_RELATED))) {
							dto.setBodyParams(readFluxBodyAsString(exchange));
						}
					}
					dto.setBehaviorEndpoint(getRequestIp(exchange.getRequest()));
				} catch (Exception ex) {
				}
				
				ScheduledExecutor.getScheduledExecutor().execute(new ThreadBehavior(discoveryClient, ThreadBehavior.BehaviorType.request, dto));
				return chain.filter(exchange.mutate().response(resolveResponse(exchange)).build());
			}
		}
		
		return chain.filter(exchange);
	}

	protected ServerHttpResponseDecorator resolveResponse(ServerWebExchange exchange) {
		ServerHttpResponseDecorator response = new ServerHttpResponseDecorator(exchange.getResponse()) {
			@Override
			public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
				String authorizedUrl = getPathWithinApplication(exchange);
				if(StringUtil.isEmpty(authorizedUrl) || authorizedUrl.indexOf("/api/sys/behavior") < 0) {
					LOGGER.info(String.format("BehaviorFilter receive response(%s), url is %s, status code is %s", exchange.getRequest().getId(), authorizedUrl, getStatusCode()));
					if (getStatusCode().equals(HttpStatus.OK) && body instanceof Flux) {
						StringBuilder sb = new StringBuilder();
						Flux<? extends DataBuffer> fluxBody = Flux.from(body);
						return super.writeWith(fluxBody.buffer().map(buffers -> {
							byte[] aryByte = new byte[0];
							for(DataBuffer buffer : buffers) {
								byte[] bytes = new byte[buffer.readableByteCount()];
		                        buffer.read(bytes);
		                        sb.append(new String(bytes, StandardCharsets.UTF_8));
		                        aryByte = ArrayUtils.addAll(aryByte, bytes);
		                        DataBufferUtils.release(buffer);
							};
							String bodyResponse = null;
							List<String> contentEncodings = exchange.getResponse().getHeaders().get(HttpHeaders.CONTENT_ENCODING);
							if (!CollectionUtils.isEmpty(contentEncodings) && contentEncodings.contains("gzip")) {
								GZIPInputStream gzipInputStream = null;
	                            try {
	                                gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(aryByte), aryByte.length);
	                                StringWriter writer = new StringWriter();
	                                IOUtils.copy(gzipInputStream, writer, "UTF-8");
	                                bodyResponse = writer.toString();
	                                if (bodyResponse.length() > 2000) {
	                                	bodyResponse = bodyResponse.substring(0, 2000) + "...";
	                                }
	                            } catch (Exception e) {
	                            	if (sb.length() > 2000) {
	    								bodyResponse = sb.substring(0, 2000) + "...";
	    							} else {
	    								bodyResponse = sb.toString();
	    							}
	                            } finally {
	                                if (gzipInputStream != null) {
	                                    try {
	                                        gzipInputStream.close();
	                                    } catch (Exception e) {
	                                    }
	                                }
	                            }
							} else {
								if (sb.length() > 2000) {
									bodyResponse = sb.substring(0, 2000) + "...";
								} else {
									bodyResponse = sb.toString();
								}
							}
							BehaviorDto dto = new BehaviorDto();
							dto.setHttpStatus(String.valueOf(getStatusCode().value()));
							dto.setRequestId(exchange.getRequest().getId());
							dto.setBodyResponse(bodyResponse);
							ScheduledExecutor.getScheduledExecutor().execute(new ThreadBehavior(discoveryClient, ThreadBehavior.BehaviorType.response, dto));
							return exchange.getResponse().bufferFactory().wrap(aryByte);
	                    }));
					} else {
						if (!getStatusCode().equals(HttpStatus.OK)) {
							BehaviorDto dto = new BehaviorDto();
							dto.setHttpStatus(String.valueOf(getStatusCode().value()));
							dto.setRequestId(exchange.getRequest().getId());
							dto.setBodyResponse("HttpStatus code is " + getStatusCode());
							ScheduledExecutor.getScheduledExecutor().execute(new ThreadBehavior(discoveryClient, ThreadBehavior.BehaviorType.response, dto));
						}
					}
				} else {
					LOGGER.info(String.format("BehaviorFilter receive response(%s), url is %s, original response", exchange.getRequest().getId(), authorizedUrl));
				}
				
				return super.writeWith(body);
			}
		};
		return response;
	}
	
	/**
	 * 从缓存里获取当前登录用户的PartyId
	 * @param exchange
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Long getUserId(ServerWebExchange exchange) {
		try {
			String token = exchange.getRequest().getHeaders()
					.getFirst(GatewayConstants.gatewayProperties.getSaveToHeader());
			if (!StringUtil.isEmpty(token)) {
				String strUser = (String) shiroRedisCache
						.get(GatewayConstants.gatewayProperties.getUserKey() + ":" + token);
				if (StringUtil.isEmpty(strUser)) {
					return -999L;
				} else {
					Map<String, Object> user = JsonBeanUtil.jsonToBean(strUser, HashMap.class);
					if (user != null && user.containsKey("partyId")) {
						return Long.parseLong(String.valueOf(user.get("partyId")));
					} else {
						return -999L;
					}
				}
			} else {
				return -999L;
			}
		} catch (Exception ex) {
			return -999L;
		}
	}
	/**
	 * 获取body里的内容
	 * 
	 * @param exchange
	 * @return
	 */
	protected String readFluxBodyAsString(ServerWebExchange exchange) {
		StringBuilder builder = new StringBuilder();
		exchange.getRequest().getBody().subscribe(buffer -> {
			byte[] bytes = new byte[buffer.readableByteCount()];
			buffer.read(bytes);
			builder.append(new String(bytes, StandardCharsets.UTF_8));
			DataBufferUtils.release(buffer);
		});
		return builder.toString();
	}

	/**
	 * 
	 * @param url
	 * @return true时表示需要做行为记录
	 */
	protected boolean shouldBehaviorFilter(String url) {
    	if (StringUtil.isEmpty(GatewayConstants.gatewayProperties.getBehaviorExcludeUrl())) {
        	return true;
        } else {
        	String[] aryCheckUrl;
        	if (GatewayConstants.gatewayProperties.getBehaviorExcludeUrl().indexOf(",") > 0) {
        		aryCheckUrl = GatewayConstants.gatewayProperties.getBehaviorExcludeUrl().split(",");
        	} else {
        		aryCheckUrl = GatewayConstants.gatewayProperties.getBehaviorExcludeUrl().split(" ");
        	}
            return !(matchPath(url, Arrays.asList(aryCheckUrl)));
        }
    }
	
	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE + 99998;
	}
	
	static class ThreadBehavior implements Runnable{
		enum BehaviorType {
			request, response;
		}
		private DiscoveryClient discoveryClient;
		private BehaviorDto dto;
		private BehaviorType behaviorType;
		ThreadBehavior(DiscoveryClient discoveryClient, BehaviorType behaviorType, BehaviorDto behaviorDto){
			this.discoveryClient = discoveryClient;
			this.behaviorType = behaviorType;
			this.dto = behaviorDto;
		}
		@Override
		public void run() {
			// 用户行为记录
			try {
				StringBuffer listOfServers = new StringBuffer();
				List<ServiceInstance> serviceInstances = discoveryClient.getInstances(GatewayConstants.gatewayProperties.getBehaviorService());
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

				BehaviorConsumer service = Feign.builder()
						.client(client).encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
						.target(BehaviorConsumer.class, "http://" + GatewayConstants.gatewayProperties.getBehaviorService());
				
				if (BehaviorType.request.equals(behaviorType)) {
					service.record(dto);
				} else {
					service.recordResonse(dto);
				}
			} catch (Exception ex) {
				LOGGER.error("用户行为记录出现异常，异常情况：{}" , ex);
			}
		}
	}
	
	static class ScheduledExecutor {

		private static class LazyHolder {
			private static Thread _ShutdownThread;
			static ScheduledExecutorService _ScheduledExecutor = null;
			static {
				_ScheduledExecutor = TtlExecutors.getTtlScheduledExecutorService(
						new ScheduledThreadPoolExecutor(20, new CmfaThreadFactory("GatewayExecutor")));
				_ShutdownThread = new Thread(new Runnable() {
					public void run() {
						shutdownExecutorPool();
					}
				});
				Runtime.getRuntime().addShutdownHook(_ShutdownThread);
			}

			private static void shutdownExecutorPool() {
				if (_ScheduledExecutor != null) {
					_ScheduledExecutor.shutdown();
					if (_ShutdownThread != null) {
						try {
							Runtime.getRuntime().removeShutdownHook(_ShutdownThread);
						} catch (IllegalStateException ise) {
						}
					}
				}
			}
		}

		static ScheduledExecutorService getScheduledExecutor() {
			return LazyHolder._ScheduledExecutor;
		}
	}
	
	static class CmfaThreadFactory implements ThreadFactory {
		private static final AtomicInteger poolNumber = new AtomicInteger(1);
		private final ThreadGroup group;
		private final AtomicInteger threadNumber = new AtomicInteger(1);
		private final String namePrefix;

		CmfaThreadFactory(String threadName) {
			SecurityManager s = System.getSecurityManager();
			group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
			namePrefix = "BehaviorPool-" + poolNumber.getAndIncrement() + "-" + threadName + "-";
		}

		public Thread newThread(Runnable r) {
			Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
			if (t.isDaemon())
				t.setDaemon(false);
			if (t.getPriority() != Thread.NORM_PRIORITY)
				t.setPriority(Thread.NORM_PRIORITY);
			return t;
		}
	}
	
}
