package org.cdqt.module.security.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 动态国际化配置
 *
 * @author LiuGangQiang Create in 2020/03/29
 */
@Configuration
public class I18nConfiguration implements WebMvcConfigurer {

	/**
	 * 设置LocaleResolver
	 *
	 * @author LiuGangQiang Create in 2020/03/29
	 * @return {@link LocaleResolver}
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver lr = new SessionLocaleResolver();
		lr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		// AcceptHeaderLocaleResolver lr=new AcceptHeaderLocaleResolver();
		// lr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return lr;
	}

	/**
	 * 配置国际化参数拦截器
	 *
	 * @author LiuGangQiang Create in 2020/03/30
	 * @return {@link LocaleChangeInterceptor}
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	/**
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

}
