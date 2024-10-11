package com.exp.gateway.filter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import com.egrid.cache.jedis.cache.RedisCache;
import com.egrid.core.util.Md5Util;
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.gateway.constant.GatewayConstants;

import reactor.core.publisher.Mono;

/**
 * 预防重复提交过滤器
 * 同一个用户，短期内提交相同的内容，视为重复提交
 * 
 * @author Yyf
 *
 */
public class ResubmitFilter extends AbstractFilter implements Ordered, GlobalFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);
	@Autowired
	private RedisCache shiroRedisCache;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		if (!GatewayConstants.gatewayProperties.getResubmitSwitch()) {
			/*如果重复提交开关关闭，直接走下一步*/
			return chain.filter(exchange);
		}
		ServerHttpRequest req = exchange.getRequest();
		if (HttpMethod.POST.name().equalsIgnoreCase(req.getMethodValue())
				|| HttpMethod.PUT.name().equalsIgnoreCase(req.getMethodValue())
				|| HttpMethod.DELETE.name().equalsIgnoreCase(req.getMethodValue())) {
			MediaType mediaType = exchange.getRequest().getHeaders().getContentType();
			if (mediaType != null && !(mediaType.equals(MediaType.MULTIPART_FORM_DATA)
					|| mediaType.equals(MediaType.MULTIPART_MIXED) || mediaType.equals(MediaType.MULTIPART_RELATED))) {
				Boolean isCheck = null;
				String url = getPathWithinApplication(exchange);
				String tmp = req.getHeaders().getFirst(GatewayConstants.gatewayProperties.getResubmitHeader());
				if (!StringUtil.isEmpty(tmp)) {
					if (("true".equals(tmp.toLowerCase())
									|| "on".equals(tmp.toLowerCase())
									|| "open".equals(tmp.toLowerCase())
									|| "o".equals(tmp.toLowerCase()))) {
						isCheck = true;
					} else {
						isCheck = false;
					}
				}
				if (isCheck == null) {
					if (shouldResubmitFilter(url)) {
						isCheck = true;
					} else {
						isCheck = false;
					}
				}
				if (isCheck) {
					Long resubmitTimeLimit = 0L;
					if (!StringUtil.isEmpty(req.getHeaders().getFirst(GatewayConstants.gatewayProperties.getResubmitTimeLimitHeader()))) {
						try {
							resubmitTimeLimit = Long.valueOf(req.getHeaders().getFirst(GatewayConstants.gatewayProperties.getResubmitTimeLimitHeader()));
						} catch (Exception ex) {
							resubmitTimeLimit = GatewayConstants.gatewayProperties.getResubmitTimeLimit();
						}
					} else {
						resubmitTimeLimit = GatewayConstants.gatewayProperties.getResubmitTimeLimit();
					}
					String token = req.getHeaders().getFirst(GatewayConstants.gatewayProperties.getSaveToHeader());
					if (!StringUtil.isEmpty(token)) {
						try {
							Long startTime = new Date().getTime();
							/*只有用户已经登录的，才会判断*/
							String method = req.getMethodValue();
							
							String query = req.getQueryParams().size() > 0 ? req.getQueryParams().toString() : "";
							String body = readFluxBodyAsString(exchange);
							StringBuilder sb = new StringBuilder().append(token).append(method).append(url).append(query)
									.append(body);
							String md5String = Md5Util.getMD5String(sb.toString());
							Long frequence = shiroRedisCache.incrBy("gateway:frequence:submit:" + md5String, 1);
							/*指定秒之内的提交，会判断重复提交*/
							shiroRedisCache.expire("gateway:frequence:submit:" + md5String, TimeUnit.SECONDS, resubmitTimeLimit);
							
							LOGGER.info(String.format("ReqID[%s] ResubmitFilter url is %s %s, md5 is %s frequence is %s time is %s, token is %s",
									exchange.getRequest().getId(), exchange.getRequest().getMethod(), url, md5String, frequence, (new Date().getTime() - startTime), token));
							if (frequence > 1) {
								return badResponse(exchange, HttpStatus.TOO_MANY_REQUESTS, RestStatusCode.DUPLICATE_KEY,
										new Exception("同个用户多次提交相同的请求"));
							} else {
								return chain.filter(exchange);
							}
						} catch (Exception ex) {
							/*防重复提交出现异常的话，继续往后走*/
							return chain.filter(exchange);
						}
					}
				}
			}
		}
		return chain.filter(exchange);
	}

	private String readFluxBodyAsString(ServerWebExchange exchange) {
		StringBuilder builder = new StringBuilder();
		exchange.getRequest().getBody().subscribe(buffer -> {
			byte[] bytes = new byte[buffer.readableByteCount()];
			buffer.read(bytes);
			builder.append(new String(bytes, StandardCharsets.UTF_8));
			DataBufferUtils.release(buffer);
		});
		return builder.toString();
	}

	protected boolean shouldResubmitFilter(String url) {
    	if (StringUtil.isEmpty(GatewayConstants.gatewayProperties.getResubmitCheckUrl())) {
        	return false;
        } else {
        	String[] aryCheckUrl;
        	if (GatewayConstants.gatewayProperties.getResubmitCheckUrl().indexOf(",") > 0) {
        		aryCheckUrl = GatewayConstants.gatewayProperties.getResubmitCheckUrl().split(",");
        	} else {
        		aryCheckUrl = GatewayConstants.gatewayProperties.getResubmitCheckUrl().split(" ");
        	}
            return matchPath(url, Arrays.asList(aryCheckUrl));
        }
    }
	
	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE + 99999;
	}
}
