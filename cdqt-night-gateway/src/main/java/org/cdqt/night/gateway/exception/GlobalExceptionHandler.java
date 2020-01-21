package org.cdqt.night.gateway.exception;

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
 * @author LiuGangQiang Create in 2020/01/21
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 异常处理
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 * @param e 异常
	 * @return 处理后的异常信息
	 */
	@ExceptionHandler(Exception.class)
	public JsonApi<?> defaultErrorHandler(Exception e) {
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("system appear error msg --> {}", e.toString());
		}
		return new JsonApi<>(ApiCodeEnum.ERROR).setMsg(e.toString());
	}
}
