package org.cdqt.study.security.exception;

import java.util.Locale;

import org.cdqt.night.core.exception.QtRuntimeException;
import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.Prompt;
import org.cdqt.night.core.result.ResultApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;

/**
 * 全局异常处理器
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
@ControllerAdvice
@Controller
public class GlobalExceptionHandler implements ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 404错误拦截
	 *
	 * @author LiuGangQiang Create in 2020/04/22
	 * @return {@link ResultApi}
	 */
	@RequestMapping(value = { "/error" })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResultApi<?> error() {
		Locale locale = LocaleContextHolder.getLocale();
		return new ResultApi<>(ApiStatus.METHOD_NOT_FOUND).setLocale(locale);
	}

	/**
	 * 方法不被允许异常处理
	 *
	 * @author LiuGangQiang Create in 2020/04/20
	 * @param e {@link HttpRequestMethodNotSupportedException}
	 * @return {@link ResultApi}
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public ResultApi<?> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		if (logger.isWarnEnabled()) {
			logger.warn("method not allowed message --> {}", e.toString());
		}
		return new ResultApi<>(ApiStatus.METHOD_NOT_ALLOWED).setMsg(e.toString());
	}

	/**
	 * 数据校验异常处理(用于表单)
	 *
	 * @author LiuGangQiang Create in 2020/03/29
	 * @param e {@link BindException}
	 * @return {@link ResultApi}
	 */
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResultApi<?> bindErrorHandler(BindException e) {
		BindingResult result = e.getBindingResult();
		if (logger.isErrorEnabled()) {
			logger.error("validator message [form] --> {}", result.getFieldError().getDefaultMessage());
		}
		return new ResultApi<>(ApiStatus.BAD_REQUEST).setMsg(result.getFieldError().getDefaultMessage());
	}

	/**
	 * 数据校验异常处理(用于application/json)
	 *
	 * @author LiuGangQiang Create in 2020/03/29
	 * @param e {@link BindException}
	 * @return {@link ResultApi}
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResultApi<?> bindErrorHandler(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		if (logger.isErrorEnabled()) {
			logger.error("validator message [json] --> {}", result.getFieldError().getDefaultMessage());
		}
		return new ResultApi<>(ApiStatus.BAD_REQUEST).setMsg(result.getFieldError().getDefaultMessage());
	}

	/**
	 * 自定义异常处理
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @param e 异常
	 * @return {@link Object} 对象
	 */
	@ExceptionHandler(QtRuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Object defaultErrorHandler(QtRuntimeException e, HandlerMethod method) {
		Locale locale = LocaleContextHolder.getLocale();
		/* 获取消息 */
		String message = Prompt.bundle(locale, e.getMessage(), e.getArgs());
		if (logger.isErrorEnabled()) {
			logger.error("system appear error msg --> {}", message);
		}
		/* 如果是下载文件则返回 {@link ResponseEntity} */
		if (method.getMethod().getReturnType() == ResponseEntity.class) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResultApi<>(ApiStatus.ERROR).setMsg(message);
	}

	/**
	 * 默认异常处理器
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @param e 异常
	 * @return {@link Object} 对象
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Object defaultErrorHandler(Exception e, HandlerMethod method) {
		e.printStackTrace();
		if (logger.isErrorEnabled()) {
			logger.error("system appear error msg --> {}", e.toString());
		}
		/* 如果是下载文件则返回 {@link ResponseEntity} */
		if (method.getMethod().getReturnType() == ResponseEntity.class) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResultApi<>(ApiStatus.ERROR).setMsg(e.toString());
	}

	/**
	 * @see org.springframework.boot.web.servlet.error.ErrorController#getErrorPath()
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
