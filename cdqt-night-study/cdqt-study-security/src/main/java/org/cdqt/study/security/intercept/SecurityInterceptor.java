package org.cdqt.study.security.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 权限拦截器
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 用户信息标识 值为 {@value}
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	// private final static String USER_FLAG = "id";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			return true;
		}
		return true;
	}
}
