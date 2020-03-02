/**
 * Copyright © 2020 Night Technology Co.Ltd All Rights Reserved.
 */
package org.cdqt.module.provider.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * ValidatorConfiguration
 *
 * @author LiuGangQiang Create in 2020/02/26
 */
public class ValidatorConfiguration {

	/**
	 * getMessageSource 配置ResourceBundleMessageSource
	 *
	 * @author LiuGangQiang Create in 2020/02/29
	 * @return {@link ResourceBundleMessageSource}
	 */
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setDefaultEncoding("UTF-8");
		rbms.setBasenames("i18n/validator");
		return rbms;
	}

	/**
	 * getValidator 获取Validator
	 *
	 * @author LiuGangQiang Create in 2020/02/29
	 * @return {@link Validator}
	 */
	@Bean
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(getMessageSource());
		return validator;
	}

}
