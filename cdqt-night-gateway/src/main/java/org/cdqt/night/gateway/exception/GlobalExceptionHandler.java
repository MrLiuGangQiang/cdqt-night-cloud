package org.cdqt.night.gateway.exception;

import org.cdqt.night.core.result.CodeEnum;
import org.cdqt.night.core.result.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 *
 * @author LiuGangQiang Create in 2020/03/01
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 异常处理器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param e 异常
	 * @return {@link ResultSet} 对象
	 */
	@ExceptionHandler(Exception.class)
	public ResultSet<?> defaultErrorHandler(Exception e) {
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("system appear error msg --> {}", e.toString());
		}
		return new ResultSet<>(CodeEnum.ERROR).setMsg(e.toString());
	}
}
