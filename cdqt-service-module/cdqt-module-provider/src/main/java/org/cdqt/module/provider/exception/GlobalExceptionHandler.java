package org.cdqt.module.provider.exception;

import org.cdqt.night.core.result.ApiCodeEnum;
import org.cdqt.night.core.result.JsonApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 默认异常处理器
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @param e 异常
	 * @return {@link JsonApi} 对象
	 */
	@ExceptionHandler(Exception.class)
	public JsonApi<?> defaultErrorHandler(Exception e) {
		if (logger.isErrorEnabled()) {
			logger.error("system appear error msg --> {}", e.getMessage());
		}
		return new JsonApi<>(ApiCodeEnum.ERROR).setMsg(e.getMessage());
	}
}
