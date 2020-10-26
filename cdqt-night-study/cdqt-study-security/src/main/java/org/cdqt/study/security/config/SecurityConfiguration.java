package org.cdqt.study.security.config;

import org.cdqt.study.security.intercept.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 权限拦截器配置
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {
	/**
	 * 实例化 {@link SecurityInterceptor} 对象
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @return {@link SecurityInterceptor} 对象
	 */
	@Bean
	public SecurityInterceptor securityInterceptor() {
		return new SecurityInterceptor();
	}

	/**
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(securityInterceptor()).addPathPatterns("/**");
	}
}