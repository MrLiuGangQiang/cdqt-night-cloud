package org.cdqt.module.mongo.config;

import org.cdqt.module.mongo.intercept.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 权限拦截器配置
 *
 * @author LiuGangQiang Create in 2020/01/23
 */
@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {

	/**
	 * 实例化 {@link SecurityInterceptor}
	 *
	 * @author LiuGangQiang Create in 2020/01/23
	 * @return {@link SecurityInterceptor}
	 */
	@Bean
	public SecurityInterceptor getSecurityInterceptor() {
		return new SecurityInterceptor();
	}

	/**
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/* 测试阶段暂时注释 */
		/* registry.addInterceptor(getSecurityInterceptor()).addPathPatterns("/**"); */
	}
}