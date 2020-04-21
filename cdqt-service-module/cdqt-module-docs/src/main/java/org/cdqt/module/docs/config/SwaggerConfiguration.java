package org.cdqt.module.docs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	/**
	 * Controller路径
	 *
	 * @author LiuGangQiang Create in 2020/04/21
	 */
	private static final String BASE_PACKAGE = "org.cdqt.module.docs.controller";

	/**
	 * 创建 {@link Docket}
	 *
	 * @author LiuGangQiang Create in 2020/04/21
	 * @return {@link Docket}
	 */
	@Bean
	public Docket createApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(PathSelectors.any()).build();
	}

	@Bean
	public RequestMappingInfoHandlerMapping requestMapping() {
		return new RequestMappingHandlerMapping();
	}

	/**
	 * 设置API文档信息
	 *
	 * @author LiuGangQiang Create in 2020/04/21
	 * @return {@link ApiInfo}
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().build();
	}
}
