/**
 * Copyright © 2020 Night Technology Co.Ltd All Rights Reserved.
 */
package org.cdqt.module.provider.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * ValidatorConfiguration
 *
 * @author LiuGangQiang Create in 2020/02/26
 */
@Configuration
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
		/* 配置校验器 设置快速失败模式 */
		ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory();
		return validatorFactory.getValidator();
	}

}
