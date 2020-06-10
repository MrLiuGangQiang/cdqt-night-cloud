package org.cdqt.module.consumer.service.config;

import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * FeignRequestInterceptor
 *
 * @author LiuGangQiang Create in 2020/06/10
 */
@Configuration
public class FeignConfig implements RequestInterceptor {
	public void apply(RequestTemplate template) {
		template.header("token", "123456");
	}
}
