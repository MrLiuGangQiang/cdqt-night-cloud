package org.cdqt.module.mongo.exception;

import org.cdqt.night.core.result.CodeEnum;
import org.cdqt.night.core.result.ResultApi;
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
	 * @return {@link ResultApi}
	 */
	@ExceptionHandler(BindException.class)
	public ResultApi<?> bindErrorHandler(BindException e) {
		BindingResult result = e.getBindingResult();
		if (logger.isErrorEnabled()) {
			logger.error("validator message [form] --> {}", result.getFieldError().getDefaultMessage());
		}
		return new ResultApi<>(CodeEnum.BAD_REQUEST).setMsg(result.getFieldError().getDefaultMessage());
	}

	/**
	 * 数据校验异常处理(用于application/json)
	 *
	 * @author LiuGangQiang Create in 2020/03/29
	 * @param e {@link BindException}
	 * @return {@link ResultApi}
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResultApi<?> bindErrorHandler(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		if (logger.isErrorEnabled()) {
			logger.error("validator message [json] --> {}", result.getFieldError().getDefaultMessage());
		}
		return new ResultApi<>(CodeEnum.BAD_REQUEST).setMsg(result.getFieldError().getDefaultMessage());
	}

	/**
	 * 默认异常处理器
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @param e 异常
	 * @return {@link ResultApi} 对象
	 */
	@ExceptionHandler(Exception.class)
	public ResultApi<?> defaultErrorHandler(Exception e) {
		if (logger.isErrorEnabled()) {
			e.printStackTrace();
			logger.error("system appear error msg --> {}", e.getMessage());
		}
		return new ResultApi<>(CodeEnum.ERROR).setMsg(e.getMessage());
	}

}
