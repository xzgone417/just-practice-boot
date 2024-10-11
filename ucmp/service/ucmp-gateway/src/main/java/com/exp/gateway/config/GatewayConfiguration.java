package com.exp.gateway.config;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.event.EnableBodyCachingEvent;
import org.springframework.cloud.gateway.filter.AdaptCachedBodyGlobalFilter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.exp.gateway.constant.GatewayConstants;
import com.exp.gateway.filter.AccessFilter;
import com.exp.gateway.filter.BehaviorFilter;
import com.exp.gateway.filter.ResubmitFilter;
import com.exp.gateway.util.SpringBootBindUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@Configuration
public class GatewayConfiguration implements EnvironmentAware {
	private static final Logger LOGGER = LoggerFactory.getLogger(GatewayConfiguration.class);

	@Autowired
	private AdaptCachedBodyGlobalFilter adaptCachedBodyGlobalFilter;
	@Autowired
	private GatewayProperties springGatewayProperties;

	@PostConstruct
	public void init() {
		// 让每一个路径都做body
		// Cache，这样重试有Body的请求的时候，重试的请求不会没有body，因为原始body是一次性的基于netty的FluxReceive
		springGatewayProperties.getRoutes().forEach(routeDefinition -> {
			EnableBodyCachingEvent enableBodyCachingEvent = new EnableBodyCachingEvent(new Object(),
					routeDefinition.getId());
			adaptCachedBodyGlobalFilter.onApplicationEvent(enableBodyCachingEvent);
		});
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

	// @Bean
	// public CacheBodyGlobalFilter cacheBodyGlobalFilter() {
	// return new CacheBodyGlobalFilter();
	// }

	@Bean
	public ResubmitFilter resubmitFilter() {
		return new ResubmitFilter();
	}
	
	@Bean
	public BehaviorFilter behaviorFilter() {
		return new BehaviorFilter();
	}

	@Override
	public void setEnvironment(Environment environment) {
		GatewayConstants.gatewayProperties = new GatewayConstants.GatewayProperties();
		
		Properties property = SpringBootBindUtil.bind(environment, Properties.class, "auth");
		if (property != null) {
			if (!StringUtils.isEmpty(property.getProperty("service"))) {
				GatewayConstants.gatewayProperties.setAuthService(property.getProperty("service"));
			} else {
				GatewayConstants.gatewayProperties.setAuthService("service-auth");
			}

			if (!StringUtils.isEmpty(property.getProperty("headers"))) {
				GatewayConstants.gatewayProperties.setSaveToHeader(property.getProperty("headers"));
			} else {
				GatewayConstants.gatewayProperties.setSaveToHeader("cmf-auth-token");
			}

			if (!StringUtils.isEmpty(property.getProperty("userKey"))) {
				GatewayConstants.gatewayProperties.setUserKey(property.getProperty("userKey"));
			} else {
				GatewayConstants.gatewayProperties.setUserKey("cmf-auth-token");
			}

			if (!StringUtils.isEmpty(property.getProperty("filterUrlStorage"))) {
				GatewayConstants.gatewayProperties
						.setFilterUrlStorage(property.getProperty("filterUrlStorage"));
			} else {
				GatewayConstants.gatewayProperties.setFilterUrlStorage("authorizedUrl");
			}

			if (!StringUtils.isEmpty(property.getProperty("excludeAuthenticateUrl"))) {
				GatewayConstants.gatewayProperties
						.setExcludeAuthenticateUrl(property.getProperty("excludeAuthenticateUrl"));
			}

			if (!StringUtils.isEmpty(property.getProperty("excludeAuthorizedUrl"))) {
				GatewayConstants.gatewayProperties
						.setExcludeAuthorizedUrl(property.getProperty("excludeAuthorizedUrl"));
			}
			property = null;
		}
		
		property = SpringBootBindUtil.bind(environment, Properties.class, "gateway.websocket");
		if (property != null) {
			if (!StringUtils.isEmpty(property.getProperty("infoUrl"))) {
				GatewayConstants.gatewayProperties.setWebsocketInfoUrl(property.getProperty("infoUrl"));
			} else {
				GatewayConstants.gatewayProperties.setWebsocketInfoUrl("/websocket/ws/info");
			}
			property = null;
		}

		property = SpringBootBindUtil.bind(environment, Properties.class, "gateway.resubmit");
		if (property != null) {
			if (!StringUtils.isEmpty(property.getProperty("switch"))
					&& ("true".equals(property.getProperty("switch").toLowerCase())
							|| "on".equals(property.getProperty("switch").toLowerCase())
							|| "open".equals(property.getProperty("switch").toLowerCase())
							|| "o".equals(property.getProperty("switch").toLowerCase()))) {
				GatewayConstants.gatewayProperties.setResubmitSwitch(true);
			} else {
				GatewayConstants.gatewayProperties.setResubmitSwitch(false);
			}
			if (!StringUtils.isEmpty(property.getProperty("limitSeconds"))) {
				try {
					GatewayConstants.gatewayProperties
							.setResubmitTimeLimit(Long.valueOf(property.getProperty("limitSeconds")));
				} catch (Exception ex) {
					GatewayConstants.gatewayProperties.setResubmitTimeLimit(8L);
				}
			} else {
				GatewayConstants.gatewayProperties.setResubmitTimeLimit(8L);
			}
			if (!StringUtils.isEmpty(property.getProperty("resubmitHeader"))) {
				GatewayConstants.gatewayProperties.setResubmitHeader(property.getProperty("resubmitHeader"));
			} else {
				GatewayConstants.gatewayProperties.setResubmitHeader("cmf-resubmit-check");
			}
			if (!StringUtils.isEmpty(property.getProperty("timeLimitHeader"))) {
				GatewayConstants.gatewayProperties.setResubmitTimeLimitHeader(property.getProperty("timeLimitHeader"));
			} else {
				GatewayConstants.gatewayProperties.setResubmitTimeLimitHeader("cmf-resubmit-time");
			}
			if (!StringUtils.isEmpty(property.getProperty("resubmitDefaultUrl"))) {
				GatewayConstants.gatewayProperties
						.setResubmitCheckUrl(property.getProperty("resubmitDefaultUrl"));
			}
			property = null;
		}
		
		property = SpringBootBindUtil.bind(environment, Properties.class, "gateway.behavior");
		if (property != null) {
			if (!StringUtils.isEmpty(property.getProperty("switch"))
					&& ("true".equals(property.getProperty("switch").toLowerCase())
							|| "on".equals(property.getProperty("switch").toLowerCase())
							|| "open".equals(property.getProperty("switch").toLowerCase())
							|| "o".equals(property.getProperty("switch").toLowerCase()))) {
				GatewayConstants.gatewayProperties.setBehaviorSwitch(true);
			} else {
				GatewayConstants.gatewayProperties.setBehaviorSwitch(false);
			}
			if (!StringUtils.isEmpty(property.getProperty("excludeUrl"))) {
				GatewayConstants.gatewayProperties
						.setBehaviorExcludeUrl(property.getProperty("excludeUrl"));
			} else {
				GatewayConstants.gatewayProperties.setBehaviorExcludeUrl("");
			}
			if (!StringUtils.isEmpty(property.getProperty("service"))) {
				GatewayConstants.gatewayProperties.setBehaviorService(property.getProperty("service"));
			} else {
				GatewayConstants.gatewayProperties.setBehaviorService("service-system");
			}
			property = null;
		}
		
		addNacosListener();
		
	}

	@Value("${spring.cloud.nacos.config.server-addr}")
	private String nacosServerAddr;

	@Value("${spring.cloud.nacos.config.namespace}")
	private String nacosNameSpace;

	@Value("${spring.application.name}")
	private String nacosConfigDataId;

	@Value("${spring.cloud.nacos.config.group:DEFAULT_GROUP}")
	private String nacosConfigGroup;

	@Value("${spring.cloud.nacos.config.file-extension:properties}")
	private String nacosConfigFileextension;
	
	/**
	 * 增加Nacos监听
	 */
	private void addNacosListener() {
		Properties properties = new Properties();
		properties.setProperty("serverAddr", nacosServerAddr);
		properties.setProperty("namespace", nacosNameSpace);
		try {
			ConfigService configService = NacosFactory.createConfigService(properties);
			configService.addListener(nacosConfigDataId, nacosConfigGroup, new Listener() {
				@Override
				public Executor getExecutor() {
					return null;
				}

				@Override
				public void receiveConfigInfo(String yaml) {
					try {
						if (nacosConfigFileextension.equals("yml")) {
							LOGGER.info("API网关收到配置变化的通知，将处理认证、重复提交部分的配置");
							parseYaml(yaml);
						}
					} catch (Exception e) {
						LOGGER.error("解析Nacos的Yaml配置文件失败", e);
					}
				}
			});
		} catch (Exception ex) {
			LOGGER.error("Nacos配置中心监听失败", ex);
		}
	}

	/**
	 * 解析并重设与服务相关的一些配置（如认证、重复提交）
	 * 
	 * @param yaml
	 * @throws IOException
	 */
	private void parseYaml(String yaml) throws IOException {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		Map map = mapper.readValue(yaml, Map.class);

		try {
			if (map.containsKey("auth")) {
				Map mapAuth = (Map) map.get("auth");
				if (!StringUtils.isEmpty(mapAuth.get("service"))) {
					GatewayConstants.gatewayProperties.setAuthService(String.valueOf(mapAuth.get("service")));
				} else {
					GatewayConstants.gatewayProperties.setAuthService("service-auth");
				}
				if (!StringUtils.isEmpty(mapAuth.get("headers"))) {
					GatewayConstants.gatewayProperties.setSaveToHeader(String.valueOf(mapAuth.get("headers")));
				} else {
					GatewayConstants.gatewayProperties.setSaveToHeader("cmf-auth-token");
				}
				if (!StringUtils.isEmpty(mapAuth.get("userKey"))) {
					GatewayConstants.gatewayProperties.setUserKey(String.valueOf(mapAuth.get("userKey")));
				} else {
					GatewayConstants.gatewayProperties.setUserKey("cmf-auth-token");
				}
				if (!StringUtils.isEmpty(mapAuth.get("filterUrlStorage"))) {
					GatewayConstants.gatewayProperties.setFilterUrlStorage(String.valueOf(mapAuth.get("filterUrlStorage")));
				} else {
					GatewayConstants.gatewayProperties.setFilterUrlStorage("authorizedUrl");
				}
				if (!StringUtils.isEmpty(mapAuth.get("excludeAuthenticateUrl"))) {
					GatewayConstants.gatewayProperties
							.setExcludeAuthenticateUrl(String.valueOf(mapAuth.get("excludeAuthenticateUrl")));
				} else {
					GatewayConstants.gatewayProperties.setExcludeAuthenticateUrl(null);
				}
				if (!StringUtils.isEmpty(mapAuth.get("excludeAuthorizedUrl"))) {
					GatewayConstants.gatewayProperties
							.setExcludeAuthorizedUrl(String.valueOf(mapAuth.get("excludeAuthorizedUrl")));
				} else {
					GatewayConstants.gatewayProperties.setExcludeAuthorizedUrl(null);
				}
				mapAuth = null;
			}
		} catch (Exception ex) {
			LOGGER.error("解析Nacos配置Auth部分出现异常", ex);
		}
		
		
		if (map.containsKey("gateway")) {
			try {
				if (((Map)map.get("gateway")).containsKey("websocket")) {
					Map mapWebsocket = (Map) ((Map) map.get("gateway")).get("websocket");
					if (!StringUtils.isEmpty(mapWebsocket.get("infoUrl"))) {
						GatewayConstants.gatewayProperties.setWebsocketInfoUrl(String.valueOf(mapWebsocket.get("infoUrl")));
					} else {
						GatewayConstants.gatewayProperties.setWebsocketInfoUrl("/websocket/ws/info");
					}
					mapWebsocket = null;
				}
			} catch (Exception ex) {
				LOGGER.error("解析Nacos配置Websocket部分出现异常", ex);
			}
			
			try {
				if (((Map)map.get("gateway")).containsKey("resubmit")) {
					Map mapResubmit = (Map) ((Map) map.get("gateway")).get("resubmit");
					if (!StringUtils.isEmpty(mapResubmit.get("switch"))) {
						String strSwitch = String.valueOf(mapResubmit.get("switch"));
						if (!StringUtils.isEmpty(mapResubmit.get("switch"))
								&& ("true".equals(strSwitch.toLowerCase()) || "on".equals(strSwitch.toLowerCase())
										|| "open".equals(strSwitch.toLowerCase()) || "o".equals(strSwitch.toLowerCase()))) {
							GatewayConstants.gatewayProperties.setResubmitSwitch(true);
						} else {
							GatewayConstants.gatewayProperties.setResubmitSwitch(false);
						}
					} else {
						GatewayConstants.gatewayProperties.setResubmitSwitch(false);
					}
					if (!StringUtils.isEmpty(mapResubmit.get("limitSeconds"))) {
						try {
							GatewayConstants.gatewayProperties
									.setResubmitTimeLimit(Long.valueOf(String.valueOf(mapResubmit.get("limitSeconds"))));
						} catch (Exception ex) {
							GatewayConstants.gatewayProperties.setResubmitTimeLimit(8L);
						}
					}
					if (!StringUtils.isEmpty(mapResubmit.get("resubmitHeader"))) {
						GatewayConstants.gatewayProperties.setResubmitHeader(String.valueOf(mapResubmit.get("resubmitHeader")));
					} else {
						GatewayConstants.gatewayProperties.setResubmitHeader("cmf-resubmit-check");
					}
					if (!StringUtils.isEmpty(mapResubmit.get("timeLimitHeader"))) {
						GatewayConstants.gatewayProperties.setResubmitTimeLimitHeader(String.valueOf(mapResubmit.get("timeLimitHeader")));
					} else {
						GatewayConstants.gatewayProperties.setResubmitTimeLimitHeader("cmf-resubmit-time");
					}
					if (!StringUtils.isEmpty(mapResubmit.get("resubmitDefaultUrl"))) {
						GatewayConstants.gatewayProperties
								.setResubmitCheckUrl(String.valueOf(mapResubmit.get("resubmitDefaultUrl")));
					} else {
						GatewayConstants.gatewayProperties.setResubmitCheckUrl(null);
					}
					mapResubmit = null;
				}
				
				if (((Map)map.get("gateway")).containsKey("behavior")) {
					Map mapBehavior = (Map) ((Map) map.get("gateway")).get("behavior");
					if (!StringUtils.isEmpty(mapBehavior.get("switch"))) {
						String strSwitch = String.valueOf(mapBehavior.get("switch"));
						if (!StringUtils.isEmpty(mapBehavior.get("switch"))
								&& ("true".equals(strSwitch.toLowerCase()) || "on".equals(strSwitch.toLowerCase())
										|| "open".equals(strSwitch.toLowerCase()) || "o".equals(strSwitch.toLowerCase()))) {
							GatewayConstants.gatewayProperties.setBehaviorSwitch(true);
						} else {
							GatewayConstants.gatewayProperties.setBehaviorSwitch(false);
						}
					} else {
						GatewayConstants.gatewayProperties.setBehaviorSwitch(false);
					}
					
					if (!StringUtils.isEmpty(mapBehavior.get("excludeUrl"))) {
						GatewayConstants.gatewayProperties
								.setBehaviorExcludeUrl(String.valueOf(mapBehavior.get("excludeUrl")));
					} else {
						GatewayConstants.gatewayProperties.setBehaviorExcludeUrl("");
					}
					
					if (!StringUtils.isEmpty(mapBehavior.get("service"))) {
						GatewayConstants.gatewayProperties
								.setBehaviorService(String.valueOf(mapBehavior.get("service")));
					} else {
						GatewayConstants.gatewayProperties.setBehaviorService("service-system");
					}
					mapBehavior = null;
				}
				
			} catch (Exception ex) {
				LOGGER.error("解析Nacos配置Resubmit部分出现异常", ex);
			}
		}
	}

}
