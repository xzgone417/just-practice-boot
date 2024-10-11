package com.exp.ucmp.config;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import com.fasterxml.classmate.TypeResolver;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;

import io.swagger.annotations.Api;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.Contact;
//import springfox.documentation.service.Response;
import springfox.documentation.service.ResponseMessage;

import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestStatusCode;

/**
 * Knife4j 2.0.8版本和该版本以上的新版本引用的Swagger有些不一样，新版本网关聚合有些问题，当前使用2.0.8
 * 
 */
@Configuration
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
	@Value("${spring.application.name}")
	private String appName;
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }
	
	@Bean
	public Docket configure(TypeResolver typeResolver) {
		SwaggerApiInfo info = apiInfo();
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any())// 可以根据url路径设置哪些请求加入文档，忽略哪些请求
				.build();

		docket.pathMapping("/").apiInfo(_apiInfo(info))
				.alternateTypeRules(
						AlternateTypeRules.newRule(typeResolver.resolve(Collection.class, WildcardType.class),
								typeResolver.resolve(List.class, WildcardType.class)))
				.forCodeGeneration(false);

		preConfigure(docket);

		return docket;
	}

	private ApiInfo _apiInfo(SwaggerApiInfo info) {
		return new ApiInfoBuilder().title(info.getTitle())// 设置文档的标题
				.description(info.getDescription())// 设置文档的描述
				.termsOfServiceUrl(info.getServiceUrl())// 设置文档的License信息
				.contact(new Contact("华人运通", "www.hiphi.com", null))// 设置文档的联系方式
				.version(info.getVersion())// 设置文档的版本信息
				.build();
	}

	private SwaggerApiInfo apiInfo() {
		SwaggerApiInfo info = new SwaggerApiInfo();
		if (!StringUtil.isEmpty(appName)) {
			appName = appName.toUpperCase();
		}
		// 设置文档的标题
		return info.title(appName + " RESTful APIs")
				// 设置文档的描述
				.description("更多Knife4j相关文章请关注：https://doc.xiaominfo.com/v2/documentation/description.html")
				// 设置文档的版本信息
				.version("1.0");
	}

	private void preConfigure(Docket docket) {
		docket.useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, extractStatusCodes()).extensions(openApiExtensionResolver.buildSettingExtensions());
	}

	private List<ResponseMessage> extractStatusCodes() {
		final LinkedList<ResponseMessage> list = new LinkedList<>();
		for (RestStatusCode statusCodes : RestStatusCode.values()) {
			final ResponseMessageBuilder builder = new ResponseMessageBuilder();
			final ResponseMessage message = builder.code(statusCodes.code()).message(statusCodes.message()).build();
			list.add(message);
		}
		return list;
	}

	/**
	 * <p>
	 * ClassName: SwaggerApiInfo
	 * </p>
	 * <p>
	 * Description: swagger api类
	 * </p>
	 * <p>
	 * Author: zhangzhiyu
	 * </p>
	 * <p>
	 * Date: 2018年4月10日
	 * </p>
	 */
	static class SwaggerApiInfo {
		/**
		 * <p>
		 * Field title: 设置文档的标题
		 * </p>
		 */
		private String title = "";
		/**
		 * <p>
		 * Field description: 设置文档的描述
		 * </p>
		 */
		private String description = "";
		/**
		 * <p>
		 * Field version: 设置文档的版本信息
		 * </p>
		 */
		private String version = "";
		/**
		 * <p>
		 * Field serviceUrl: 设置文档的License信息
		 * </p>
		 */
		private String serviceUrl = "";

		public String getTitle() {
			return title;
		}

		/**
		 * <p>
		 * Description: 文档标题
		 * </p>
		 * 
		 * @param titleApi
		 *            标题
		 * @return api
		 */
		public SwaggerApiInfo title(String titleApi) {
			this.title = titleApi;
			return this;
		}

		public String getDescription() {
			return description;
		}

		/**
		 * <p>
		 * Description: 描述信息
		 * </p>
		 * 
		 * @param descriptionApi
		 *            描述
		 * @return api
		 */
		public SwaggerApiInfo description(String descriptionApi) {
			this.description = descriptionApi;
			return this;
		}

		public String getVersion() {
			return version;
		}

		/**
		 * <p>
		 * Description: 版本信息
		 * </p>
		 * 
		 * @param versionApi
		 *            版本信息
		 * @return api
		 */
		public SwaggerApiInfo version(String versionApi) {
			this.version = versionApi;
			return this;
		}

		public String getServiceUrl() {
			return serviceUrl;
		}

		/**
		 * <p>
		 * Description: url
		 * </p>
		 * 
		 * @param serviceUrlApi
		 *            url
		 * @return api
		 */
		public SwaggerApiInfo serviceUrl(String serviceUrlApi) {
			this.serviceUrl = serviceUrlApi;
			return this;
		}

	}
}
