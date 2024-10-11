package com.exp.ucmp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class TemplateIdConfig {
	
	@Value("${adapter.ucmp.templateId.templateTitleFirst}")
	private String templateTitleFirst;
	
	@Value("${adapter.ucmp.templateId.templateTitleSecond}")
	private String templateTitleSecond;
	
	@Value("${adapter.ucmp.templateId.templateTitleThird}")
	private String templateTitleThird;
	
	@Value("${adapter.ucmp.templateId.templateTitleFourth}")
	private String templateTitleFourth;
	
	@Value("${adapter.ucmp.templateId.templateTitleFifth}")
	private String templateTitleFifth;
	
	@Value("${adapter.ucmp.templateId.templateTitleSixth}")
	private String templateTitleSixth;
	
	@Value("${adapter.ucmp.templateId.templateTitleSeventh}")
	private String templateTitleSeventh;
	
	@Value("${adapter.ucmp.templateId.templateTitleEighth}")
	private String templateTitleEighth;

	public String getTemplateTitleFirst() {
		return templateTitleFirst;
	}

	public void setTemplateTitleFirst(String templateTitleFirst) {
		this.templateTitleFirst = templateTitleFirst;
	}

	public String getTemplateTitleSecond() {
		return templateTitleSecond;
	}

	public void setTemplateTitleSecond(String templateTitleSecond) {
		this.templateTitleSecond = templateTitleSecond;
	}

	public String getTemplateTitleThird() {
		return templateTitleThird;
	}

	public void setTemplateTitleThird(String templateTitleThird) {
		this.templateTitleThird = templateTitleThird;
	}

	public String getTemplateTitleFourth() {
		return templateTitleFourth;
	}

	public void setTemplateTitleFourth(String templateTitleFourth) {
		this.templateTitleFourth = templateTitleFourth;
	}

	public String getTemplateTitleFifth() {
		return templateTitleFifth;
	}

	public void setTemplateTitleFifth(String templateTitleFifth) {
		this.templateTitleFifth = templateTitleFifth;
	}

	public String getTemplateTitleSixth() {
		return templateTitleSixth;
	}

	public void setTemplateTitleSixth(String templateTitleSixth) {
		this.templateTitleSixth = templateTitleSixth;
	}

	public String getTemplateTitleSeventh() {
		return templateTitleSeventh;
	}

	public void setTemplateTitleSeventh(String templateTitleSeventh) {
		this.templateTitleSeventh = templateTitleSeventh;
	}

	public String getTemplateTitleEighth() {
		return templateTitleEighth;
	}

	public void setTemplateTitleEighth(String templateTitleEighth) {
		this.templateTitleEighth = templateTitleEighth;
	}
}
