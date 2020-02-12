package org.cdqt.module.mongo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.cdqt.night.core.result.ApiCodeEnum;
import org.cdqt.night.core.result.JsonApi;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;


/**
 * ValidatorAop
 *
 * @author LiuGangQiang Create in 2020/01/23
 */
@Component
@Aspect
public class ValidatorAop {

	/** 
	 * around 环绕校验
	 *
	 * @author LiuGangQiang Create in 2020/01/23
	 * @param point
	 * @return {@link Object}
	 * @throws Throwable
	 */
	@Around("execution(public * org.cdqt.module.mongo.controller..*.*(..))")
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