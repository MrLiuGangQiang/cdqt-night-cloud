package org.cdqt.module.provider.exception;

import org.cdqt.night.core.result.CodeEnum;
import org.cdqt.night.core.result.ResultApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

/**
 * 全局异常处理器
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
@ControllerAdvice
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
	@ResponseBody
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
	@ResponseBody
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
	 * @return {@link Object} 对象
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object defaultErrorHandler(Exception e, HandlerMethod method) {
		if (logger.isErrorEnabled()) {
			logger.error("system appear error msg --> {}", e.getMessage());
		}
		/* 如果是下载文件则返回 {@link ResponseEntity} */
		if (method.getMethod().getReturnType() == ResponseEntity.class) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResultApi<>(CodeEnum.ERROR).setMsg(e.getMessage());
	}
}
