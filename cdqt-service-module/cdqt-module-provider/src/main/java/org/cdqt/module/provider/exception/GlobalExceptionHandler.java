package org.cdqt.module.provider.exception;

import org.cdqt.night.core.result.ApiCodeEnum;
import org.cdqt.night.core.result.JsonApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	 * 数据校验异常处理(用于表单)
	 *
	 * @author LiuGangQiang Create in 2020/03/29
	 * @param e {@link BindException}
	 * @return {@link JsonApi}
	 */
	@ExceptionHandler(BindException.class)
	public JsonApi<?> bindErrorHandler(BindException e) {
		BindingResult result = e.getBindingResult();
		if (logger.isErrorEnabled()) {
			logger.error("validator message [from] --> {}", result.getFieldError().getDefaultMessage());
		}
		return new JsonApi<>(ApiCodeEnum.BAD_REQUEST).setMsg(result.getFieldError().getDefaultMessage());
	}

	/**
	 * 数据校验异常处理(用于application/json)
	 *
	 * @author LiuGangQiang Create in 2020/03/29
	 * @param e {@link BindException}
	 * @return {@link JsonApi}
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public JsonApi<?> bindErrorHandler(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		if (logger.isErrorEnabled()) {
			logger.error("validator message [json] --> {}", result.getFieldError().getDefaultMessage());
		}
		return new JsonApi<>(ApiCodeEnum.BAD_REQUEST).setMsg(result.getFieldError().getDefaultMessage());
	}

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
			e.printStackTrace();
			logger.error("system appear error msg --> {}", e.getMessage());
		}
		return new JsonApi<>(ApiCodeEnum.ERROR).setMsg(e.getMessage());
	}

}
