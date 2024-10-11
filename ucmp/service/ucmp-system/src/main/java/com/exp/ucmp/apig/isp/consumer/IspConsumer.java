package com.exp.ucmp.apig.isp.consumer;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.apig.AbstractConsumer.RequestBuilder;

@Component
public class IspConsumer extends AbstractConsumer {
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IspConsumer.class);
    
    @Autowired
    private IspProperties ispProperties;
    
    protected enum IspEnum { 
    	QUERYSITEURL("/third/site/common/query"),
    	QUOTEAPPLYURL("/third/quote/apply"),
    	QUOTEAPPROVALURL("/third/quote/approval"),
    	WORKORDERHISTORY("/third/work/order/ucmp/history"),
    	WORKORDERCOMMONQUERY("/third/work/order/common/query"),
    	WORKORDERCOMMONDETAIL("/third/work/order/common/detail");

        private String url;

        private IspEnum(String value) {
            this.url = value;
        }
        public String url() {
            return this.url;
		}
	}

	public String querySite(Map<String, Object> params) throws Exception {
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(ispProperties.getKey()).secret(ispProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(ispProperties.getUri() + IspEnum.QUERYSITEURL.url)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
	}

	public String quoteApply(Map<String, Object> params) throws Exception {
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(ispProperties.getKey()).secret(ispProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(ispProperties.getUri() + IspEnum.QUOTEAPPLYURL.url)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
	}

	public String quoteApproval(Map<String, Object> params) throws Exception {
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(ispProperties.getKey()).secret(ispProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(ispProperties.getUri() + IspEnum.QUOTEAPPROVALURL.url)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
	}

	public String workOrderHistory(Map<String, Object> params) throws Exception {
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(ispProperties.getKey()).secret(ispProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(ispProperties.getUri() + IspEnum.WORKORDERHISTORY.url)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
	}

	public String workOrderQuery(Map<String, Object> params) throws Exception {
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(ispProperties.getKey()).secret(ispProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(ispProperties.getUri() + IspEnum.WORKORDERCOMMONQUERY.url)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
	}

	public String workOrderQueryDetail(String workOrderNo) throws Exception {
		String url=ispProperties.getUri()+IspEnum.WORKORDERCOMMONDETAIL.url+"?workOrderNo="+workOrderNo;
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(ispProperties.getKey()).secret(ispProperties.getSecret())
				.mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		LOGGER.info(requestBuilder.toString());
		
		return sendRequest(requestBuilder.build());
	}
    
}

