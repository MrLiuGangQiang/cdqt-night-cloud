package org.cdqt.module.provider.config;

import org.cdqt.module.provider.intercept.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SecurityConfig
 *
 * @author LiuGangQiang Create in 2020/01/23
 */
@Configuration
@EnableWebMvc
public class SecurityConfig implements WebMvcConfigurer {

	/**
	 * getSecuriJtyInterceptor 注册权限拦截器
	 *
	 * @author LiuGangQiang Create in 2020/02/29
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
		registry.addInterceptor(getSecurityInterceptor()).addPathPatterns("/**");
	}
}