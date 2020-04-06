package org.cdqt.module.mongo.advice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Locale;

import org.cdqt.night.core.message.Prompt;
import org.cdqt.night.core.result.ResultApi;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(annotations = RestController.class)
public class I18nMessageAdvice implements ResponseBodyAdvice<Object> {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		AnnotatedElement annotatedElement = returnType.getAnnotatedElement();
		return Arrays.stream(new Class[] { RequestMapping.class, GetMapping.class, PostMapping.class, DeleteMapping.class, PutMapping.class })
				.anyMatch(annotaion -> annotaion.isAnnotation() && annotatedElement.isAnnotationPresent(annotaion));
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if (body instanceof ResultApi<?>) {
			ResultApi<?> result = (ResultApi<?>) body;
			Locale locale = LocaleContextHolder.getLocale();
			/* 如果消息等于空则认为是默认消息 */
			if (result.getIsDefault()) {
				/* 获取默认路径下的资源文件 */
				result.setMsg(Prompt.bundle(ResultApi.getPath(), locale, result.getMsg()));
			} else {
				result.setMsg(Prompt.bundle(locale, result.getMsg(), result.getArgs()));
			}
			return result;
		}
		return body;
	}

}