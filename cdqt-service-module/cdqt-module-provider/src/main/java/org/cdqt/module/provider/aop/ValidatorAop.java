/**
 * Copyright © 2020 Night Technology Co.Ltd All Rights Reserved.
 */
package org.cdqt.module.provider.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.cdqt.night.core.result.ApiCodeEnum;
import org.cdqt.night.core.result.JsonApi;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * ValidatorAop 校验切点
 *
 * @author LiuGangQiang Create in 2020/02/26
 */
@Component
@Aspect
public class ValidatorAop {
	/**
	 * around
	 *
	 * @author LiuGangQiang Create in 2020/02/26
	 * @param point 切点
	 * @return {@link Object}
	 * @throws Throwable
	 */
	@Around("execution(public * org.cdqt.module.provider.controller..*.*(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object[] objects = point.getArgs();
		for (Object object : objects) {
			if (object instanceof BindingResult) {
				if (((BindingResult) object).hasErrors()) {
					return new JsonApi<>(ApiCodeEnum.BAD_REQUEST).setMsg(((BindingResult) object).getFieldError().getDefaultMessage());
				}
			}
		}
		return point.proceed();
	}
}
