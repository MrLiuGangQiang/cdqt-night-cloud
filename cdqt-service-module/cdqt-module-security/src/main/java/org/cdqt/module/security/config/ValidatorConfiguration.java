package org.cdqt.module.security.config;

import org.hibernate.validator.HibernateValidatorConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 校验配置
 *
 * @author LiuGangQiang Create in 2020/03/30
 */
@Configuration
public class ValidatorConfiguration implements WebMvcConfigurer {
	/**
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#getValidator()
	 */
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setDefaultEncoding("UTF-8");
		rbms.setBasenames("i18n/validator");
		localValidatorFactoryBean.setValidationMessageSource(rbms);
		localValidatorFactoryBean.getValidationPropertyMap().put(HibernateValidatorConfiguration.FAIL_FAST, "true");
		return localValidatorFactoryBean;
	}
}
