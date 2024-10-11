package com.exp.gateway.filter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.gateway.constant.GatewayConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

public class AbstractFilter {

	private final AntPathMatcher pathMatcher = new AntPathMatcher();
	private final List<String> ipHeaders = Arrays.asList("X-Forwarded-For", "x-forwarded-for", "X-Real-IP",
			"Proxy-Client-IP");

	protected boolean isWebSocketExchange(String scheme, String requestPath) {
		return requestPath.matches("^/websocket/ws.*") || "ws".equals(scheme) || "wss".equals(scheme)
				|| requestPath.equals(GatewayConstants.gatewayProperties.getWebsocketInfoUrl());
	}

	protected String convertWsToHttp(String scheme) {
		return "ws".equals(scheme) ? "http" : "wss".equals(scheme) ? "https" : scheme;
	}

	protected boolean matchPath(String path, List<String> rules) {
		for (int i = 0; i < rules.size(); i++) {
			if (pathMatcher.match(rules.get(i).trim(), path))
				return true;
		}
		return false;
	}

	protected String getRequestIp(ServerHttpRequest req) {
		String ip;
		HttpHeaders headers = req.getHeaders();
		for (int i = 0; i < ipHeaders.size(); i++) {
			ip = getHeaderVal(headers, ipHeaders.get(i));
			if (StringUtils.hasLength(ip))
				return ip;
		}
		try {
			return req.getRemoteAddress().getAddress().getHostAddress();
		} catch (Exception e) {
			return "";
		}
	}

	protected String getHeaderVal(HttpHeaders headers, String key) {
		try {
			String val = headers.getFirst(key);
			return "unknown".equals(val) ? null : val;
		} catch (Exception e) {
			return null;
		}
	}

	protected ServerHttpRequest addHeader(ServerHttpRequest req, String key, String val) {
		return req.mutate().header(key, new String[] { val }).build();
	}

	protected ServerHttpRequest addHeader(ServerHttpRequest req, String key, Map val) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return addHeader(req, key, mapper.writer().writeValueAsString(val));
		} catch (JsonProcessingException e) {
			return req;
		}
	}

	/**
	 * 判断请求的URL是否需要认证通过后才能访问
	 * 
	 * @param authorizedUrl
	 *            请求的URL
	 * @return True表明该URL无需认证
	 */
	protected boolean shouldAuthenticateFilter(String authorizedUrl) {
		if (StringUtil.isEmpty(GatewayConstants.gatewayProperties.getExcludeAuthenticateUrl())) {
			return true;
		} else {
			String[] aryExcludeUrl;
			if (GatewayConstants.gatewayProperties.getExcludeAuthenticateUrl().indexOf(",") > 0) {
				aryExcludeUrl = GatewayConstants.gatewayProperties.getExcludeAuthenticateUrl().split(",");
			} else {
				aryExcludeUrl = GatewayConstants.gatewayProperties.getExcludeAuthenticateUrl().split(" ");
			}
			for (int i = 0; i < aryExcludeUrl.length; i++) {
				// 如果匹配到url则不再过滤
				if (pathMatcher.match(aryExcludeUrl[i].trim(), authorizedUrl)) {
					return false;
				}
			}
			return true;// 是否执行该过滤器，此处为true，说明需要过滤
		}
	}

	/**
	 * 判断请求的URL是否需要鉴权
	 * 
	 * @param authorizedUrl
	 * @return
	 */
	protected boolean shouldAuthorizedFilter(String authorizedUrl) {
    	if (StringUtil.isEmpty(GatewayConstants.gatewayProperties.getExcludeAuthorizedUrl())) {
        	return true;
        } else {
        	String[] aryExcludeUrl;
        	if (GatewayConstants.gatewayProperties.getExcludeAuthorizedUrl().indexOf(",") > 0) {
        		aryExcludeUrl = GatewayConstants.gatewayProperties.getExcludeAuthorizedUrl().split(",");
        	} else {
        		aryExcludeUrl = GatewayConstants.gatewayProperties.getExcludeAuthorizedUrl().split(" ");
        	}
            for (int i = 0; i < aryExcludeUrl.length; i++) {
                //如果匹配到url则不再过滤
                if (pathMatcher.match(aryExcludeUrl[i].trim(), authorizedUrl)) {
                    return false;
                }
            }
            return true;// 是否执行该过滤器，此处为true，说明需要过滤  
        }
    }

	/**
	 * 异常返回
	 * 
	 * @param exchange
	 * @param status
	 * @param restStatusCode
	 * @param exception
	 * @return
	 */
	protected Mono<Void> badResponse(ServerWebExchange exchange, HttpStatus status, RestStatusCode restStatusCode, Exception exception) {
		ServerHttpResponse response = exchange.getResponse();
		RestResponse<String> restResponseCtx = new RestResponse<>(restStatusCode, exception);
		byte[] bits = JsonBeanUtil.beanToJson(restResponseCtx).getBytes(StandardCharsets.UTF_8);
		DataBuffer buffer = response.bufferFactory().wrap(bits);
		response.setStatusCode(status);
		// 指定编码，否则在浏览器中会中文乱码
		response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
		return response.writeWith(Mono.just(buffer));
	}

	/**
	 * 获取请求路径
	 * 
	 * @param exchange
	 * @return
	 */
	protected String getPathWithinApplication(ServerWebExchange exchange) {
		String path = normalize(exchange.getRequest().getPath().toString());
		return (StringUtils.hasText(path) ? path : "/");
	}

	protected String normalize(String path) {
		return normalize(path, true);
	}

	/**
	 * Normalize a relative URI path that may have relative values ("/./",
	 * "/../", and so on ) it it. <strong>WARNING</strong> - This method is
	 * useful only for normalizing application-generated paths. It does not try
	 * to perform security checks for malicious input. Normalize operations were
	 * was happily taken from org.apache.catalina.util.RequestUtil in Tomcat
	 * trunk, r939305
	 *
	 * @param path
	 *            Relative path to be normalized
	 * @param replaceBackSlash
	 *            Should '\\' be replaced with '/'
	 * @return normalized path
	 */
	protected String normalize(String path, boolean replaceBackSlash) {

		if (path == null)
			return null;

		// Create a place for the normalized path
		String normalized = path;

		if (replaceBackSlash && normalized.indexOf('\\') >= 0)
			normalized = normalized.replace('\\', '/');

		if (normalized.equals("/."))
			return "/";

		// Add a leading "/" if necessary
		if (!normalized.startsWith("/"))
			normalized = "/" + normalized;

		// Resolve occurrences of "//" in the normalized path
		while (true) {
			int index = normalized.indexOf("//");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index) + normalized.substring(index + 1);
		}

		// Resolve occurrences of "/./" in the normalized path
		while (true) {
			int index = normalized.indexOf("/./");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index) + normalized.substring(index + 2);
		}

		// Resolve occurrences of "/../" in the normalized path
		while (true) {
			int index = normalized.indexOf("/../");
			if (index < 0)
				break;
			if (index == 0)
				return (null); // Trying to go outside our context
			int index2 = normalized.lastIndexOf('/', index - 1);
			normalized = normalized.substring(0, index2) + normalized.substring(index + 3);
		}

		// Return the normalized path that we have completed
		return (normalized);
	}

}
