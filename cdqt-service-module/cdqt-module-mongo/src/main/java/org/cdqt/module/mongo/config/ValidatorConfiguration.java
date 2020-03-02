package org.cdqt.module.mongo.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 实体类校验资源配置
 *
 * @author LiuGangQiang Create in 2020/01/23
 */
@Configuration
public class ValidatorConfiguration {

	/**
	 * 获取资源路径
	 *
	 * @author LiuGangQiang Create in 2020/01/23
	 * @return {@link ResourceBundleMessageSource}
	 */
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setDefaultEncoding("UTF-8");
		rbms.setBasenames("i18n/validator");
		return rbms;
	}

	/**
	 * 实例校验器
	 *
	 * @author LiuGangQiang Create in 2020/01/23
	 * @return {@link Validator} 对象
	 */
	@Bean
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(getMessageSource());
		return validator;
	}
}