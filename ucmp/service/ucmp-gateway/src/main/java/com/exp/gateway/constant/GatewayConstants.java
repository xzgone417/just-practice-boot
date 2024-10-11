package com.exp.gateway.constant;

public class GatewayConstants {
	public static GatewayProperties gatewayProperties;
	
	public static class GatewayProperties {
		private String authService;
		private String saveToHeader;
		private String userKey;
		private String filterUrlStorage;
		private String excludeAuthenticateUrl;
		private String excludeAuthorizedUrl;
		private String websocketInfoUrl;
		
		/*重复提交相关的参数*/
		private Boolean resubmitSwitch = false;
		private Long resubmitTimeLimit;
		private String resubmitHeader;
		private String resubmitTimeLimitHeader;
		private String resubmitCheckUrl;
		
		/*行为记录相关的参数*/
		private Boolean behaviorSwitch = false;
		private String behaviorService;
		private String behaviorExcludeUrl;
		
		public String getAuthService() {
			return authService;
		}
		public void setAuthService(String authService) {
			this.authService = authService;
		}
		public String getSaveToHeader() {
			return saveToHeader;
		}
		public void setSaveToHeader(String saveToHeader) {
			this.saveToHeader = saveToHeader;
		}
		public String getUserKey() {
			return userKey;
		}
		public void setUserKey(String userKey) {
			this.userKey = userKey;
		}
		public String getFilterUrlStorage() {
			return filterUrlStorage;
		}
		public void setFilterUrlStorage(String filterUrlStorage) {
			this.filterUrlStorage = filterUrlStorage;
		}
		public String getExcludeAuthenticateUrl() {
			return excludeAuthenticateUrl;
		}
		public void setExcludeAuthenticateUrl(String excludeAuthenticateUrl) {
			this.excludeAuthenticateUrl = excludeAuthenticateUrl;
		}
		public String getExcludeAuthorizedUrl() {
			return excludeAuthorizedUrl;
		}
		public void setExcludeAuthorizedUrl(String excludeAuthorizedUrl) {
			this.excludeAuthorizedUrl = excludeAuthorizedUrl;
		}
		public String getWebsocketInfoUrl() {
			return websocketInfoUrl;
		}
		public void setWebsocketInfoUrl(String websocketInfoUrl) {
			this.websocketInfoUrl = websocketInfoUrl;
		}
		public Boolean getResubmitSwitch() {
			return resubmitSwitch;
		}
		public void setResubmitSwitch(Boolean resubmitSwitch) {
			this.resubmitSwitch = resubmitSwitch;
		}
		public Long getResubmitTimeLimit() {
			return resubmitTimeLimit;
		}
		public void setResubmitTimeLimit(Long resubmitTimeLimit) {
			this.resubmitTimeLimit = resubmitTimeLimit;
		}
		public String getResubmitHeader() {
			return resubmitHeader;
		}
		public void setResubmitHeader(String resubmitHeader) {
			this.resubmitHeader = resubmitHeader;
		}
		public String getResubmitCheckUrl() {
			return resubmitCheckUrl;
		}
		public void setResubmitCheckUrl(String resubmitCheckUrl) {
			this.resubmitCheckUrl = resubmitCheckUrl;
		}
		public String getResubmitTimeLimitHeader() {
			return resubmitTimeLimitHeader;
		}
		public void setResubmitTimeLimitHeader(String resubmitTimeLimitHeader) {
			this.resubmitTimeLimitHeader = resubmitTimeLimitHeader;
		}
		public Boolean getBehaviorSwitch() {
			return behaviorSwitch;
		}
		public void setBehaviorSwitch(Boolean behaviorSwitch) {
			this.behaviorSwitch = behaviorSwitch;
		}
		public String getBehaviorExcludeUrl() {
			return behaviorExcludeUrl;
		}
		public void setBehaviorExcludeUrl(String behaviorExcludeUrl) {
			this.behaviorExcludeUrl = behaviorExcludeUrl;
		}
		public String getBehaviorService() {
			return behaviorService;
		}
		public void setBehaviorService(String behaviorService) {
			this.behaviorService = behaviorService;
		}
		
	}
	
	public static class ShiroRedisProperties {

        /**
         * <p>
         * Field maxTotal: maxTotal
         * </p>
         */
        private Integer maxTotal = 50;
        /**
         * <p>
         * Field maxIdle: maxIdle
         * </p>
         */
        private Integer maxIdle = 10;
        /**
         * <p>
         * Field maxWaitMillis: maxWaitMillis
         * </p>
         */
        private Long maxWaitMillis = 500L;
        /**
         * <p>
         * Field testOnBorrow: testOnBorrow
         * </p>
         */
        private Boolean testOnBorrow = true;
        /**
         * <p>
         * Field testOnReturn: testOnReturn
         * </p>
         */
        private Boolean testOnReturn = true;
        /**
         * <p>
         * Field lifo: lifo
         * </p>
         */
        private Boolean lifo = true;

        /**
         * <p>
         * Field deployMode: deployMode
         * </p>
         */
        private String deployMode = "com.egrid.cache.jedis.pool.RedisGeneralPool";
        /**
         * <p>
         * Field servers: servers
         * </p>
         */
        private String servers;
        /**
         * <p>
         * Field password: password
         * </p>
         */
        private String password;
        /**
         * <p>
         * Field masterName: masterName
         * </p>
         */
        private String masterName;

        /**
         * <p>
         * Field expireTime: expireTime
         * </p>
         */
        private String expireTime = "1800";

        private String dbIndex = "0";

		public Integer getMaxTotal() {
			return maxTotal;
		}

		public void setMaxTotal(Integer maxTotal) {
			this.maxTotal = maxTotal;
		}

		public Integer getMaxIdle() {
			return maxIdle;
		}

		public void setMaxIdle(Integer maxIdle) {
			this.maxIdle = maxIdle;
		}

		public Long getMaxWaitMillis() {
			return maxWaitMillis;
		}

		public void setMaxWaitMillis(Long maxWaitMillis) {
			this.maxWaitMillis = maxWaitMillis;
		}

		public Boolean getTestOnBorrow() {
			return testOnBorrow;
		}

		public void setTestOnBorrow(Boolean testOnBorrow) {
			this.testOnBorrow = testOnBorrow;
		}

		public Boolean getTestOnReturn() {
			return testOnReturn;
		}

		public void setTestOnReturn(Boolean testOnReturn) {
			this.testOnReturn = testOnReturn;
		}

		public Boolean getLifo() {
			return lifo;
		}

		public void setLifo(Boolean lifo) {
			this.lifo = lifo;
		}

		public String getDeployMode() {
			return deployMode;
		}

		public void setDeployMode(String deployMode) {
			this.deployMode = deployMode;
		}

		public String getServers() {
			return servers;
		}

		public void setServers(String servers) {
			this.servers = servers;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMasterName() {
			return masterName;
		}

		public void setMasterName(String masterName) {
			this.masterName = masterName;
		}

		public String getExpireTime() {
			return expireTime;
		}

		public void setExpireTime(String expireTime) {
			this.expireTime = expireTime;
		}

		public String getDbIndex() {
			return dbIndex;
		}

		public void setDbIndex(String dbIndex) {
			this.dbIndex = dbIndex;
		}
        
    }
}
