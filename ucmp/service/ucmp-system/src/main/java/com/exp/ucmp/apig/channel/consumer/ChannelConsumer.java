package com.exp.ucmp.apig.channel.consumer;


import com.exp.ucmp.store.dto.ChannelStoreParamDto;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;

@Component
public class ChannelConsumer extends AbstractConsumer {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelConsumer.class);

    @Autowired
    private ChannelProperties channelProperties;

    protected enum ChannelEnum { 
    	// URM接口
    	STORELISTENABLED("/store/v1/list/enabled");

        private String url;

        private ChannelEnum(String value) {
            this.url = value;
        }

        public String url() {
            return this.url;
        }
    }

	public String storeListEnabled(Map<String, Object> params) throws Exception {
        LOGGER.info("查询组织下最新门店列表信息参数：" + JsonBeanUtil.beanToJson(params));
        RequestBuilder requestBuilder = RequestBuilder.getInstance().key(channelProperties.getKey()).secret(channelProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(channelProperties.getUri() + ChannelEnum.STORELISTENABLED.url).header("channel", "UCMP")
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
	}
}
