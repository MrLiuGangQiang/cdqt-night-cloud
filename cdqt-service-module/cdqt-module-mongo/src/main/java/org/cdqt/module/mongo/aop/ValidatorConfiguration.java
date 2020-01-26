package org.cdqt.module.mongo.aop;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * ValidatorConfiguration
 *
 * @author LiuGangQiang Create in 2020/01/23
 */
@Configuration
public class ValidatorConfiguration {

	/**
	 * getMessageSource
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
	 * getValidator
	 *
	 * @author LiuGangQiang Create in 2020/01/23
	 * @return {@link Validator}
	 */
	@Bean
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(getMessageSource());
		return validator;
	}
}