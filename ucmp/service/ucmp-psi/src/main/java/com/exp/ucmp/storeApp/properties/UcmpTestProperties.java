package com.exp.ucmp.storeApp.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class UcmpTestProperties {
	
	@Value("${adapter.ucmp.test.label}")
	private String label;
	
	@Value("${adapter.ucmp.hipi.brand}")
	private String hipiBrandId;
	
	@Value("${adapter.ucmp.hipi.abbreviation}")
	private String partnerAbbreviation;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getHipiBrandId() {
		return hipiBrandId;
	}

	public void setHipiBrandId(String hipiBrandId) {
		this.hipiBrandId = hipiBrandId;
	}

	public String getPartnerAbbreviation() {
		return partnerAbbreviation;
	}

	public void setPartnerAbbreviation(String partnerAbbreviation) {
		this.partnerAbbreviation = partnerAbbreviation;
	}
	
}
