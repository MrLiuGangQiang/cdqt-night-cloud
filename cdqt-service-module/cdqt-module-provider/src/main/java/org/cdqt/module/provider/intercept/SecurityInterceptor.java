/**
 * Copyright © 2020 Night Technology Co.Ltd All Rights Reserved.
 */
package org.cdqt.module.provider.intercept;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cdqt.night.core.auth.Authentication;
import org.cdqt.night.core.result.ApiCodeEnum;
import org.cdqt.night.core.result.JsonApi;
import org.cdqt.night.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 权限拦截器
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	private final static Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

	/**
	 * Token标识 值为 {@value}
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private final static String TOKEN_FLAG = "token";

	/**
	 * 用户信息标识 值为 {@value}
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	// private final static String USER_FLAG = "id";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			/* 构造Json处理对象 */
			ObjectMapper om = new ObjectMapper();
			/* 获取类全限定名 */
			String className = ((HandlerMethod) handler).getBeanType().getName();
			/* 获取方法名 */
			String methodName = ((HandlerMethod) handler).getMethod().getName();
			/* 设置响应头字符编码为UTF-8 */
			response.setCharacterEncoding("UTF-8");
			/* 设置响应头为Json格式 */
			response.setContentType("application/json");
			/* 获取token */
			String token = request.getHeader(TOKEN_FLAG);
			// Object uid = null;
			/* 获取方法 */
			HandlerMethod method = (HandlerMethod) handler;
			/* 获取权限注解 */
			Authentication authentication = method.getMethodAnnotation(Authentication.class);
			/* 如果权限注解为空不允许访问 */
			if (authentication == null) {
				if (logger.isWarnEnabled()) {
					logger.warn("the target method [{}#{}] is not defined", className, methodName);
				}
				response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.UNIMPLEMENTED)));
				return false;
			}
			/* 权限注解不为空 则进行鉴权判断 */
			if (authentication.ignore()) {
				/* 如果设置忽略校验直接放行 适用于类似登录注册接口 */
				return true;
			} else if (authentication.authc()) {
				/* 判断是否进行登录鉴权 */
				if (token == null) {
					/* token为空则返回参数有误状态 */
					response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.BAD_REQUEST)));
					return false;
				}
				/* TODO 这里应通过登录服务器获取用户缓存信息 */
				// JsonApi<Session<Map<String, Object>>> sessionData = 这里远程获取;
				JsonApi<Session<Map<String, Object>>> sessionData = new JsonApi<Session<Map<String, Object>>>();
				if (sessionData != null && sessionData.compare(ApiCodeEnum.OK)) {
					/* 登录信息不为空证明已登录，则放行 实际业务也可能更加严格 */
					Session<?> session = sessionData.getData();
					if (session != null) {
						return true;
					}
				}
				/* 未登录打印日志并提示 */
				if (logger.isInfoEnabled()) {
					logger.info("the access target method [{}#{}] is not logged in", className, methodName);
				}
				response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.UNAUTHORIZED)));
				return false;
			} else {
				/* 先获取用户id */
				if (token == null) {
					/* token为空则返回参数有误状态 */
					response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.BAD_REQUEST)));
					return false;
				}
				/* TODO 这里应通过登录服务器获取用户缓存信息 */
				// JsonApi<Session<Map<String, Object>>> sessionData = 这里远程获取;
				JsonApi<Session<Map<String, Object>>> sessionData = new JsonApi<Session<Map<String, Object>>>();
				/* 权限信息为空获取请求状态不为成功则代表未登录 实际业务可能更加严格 */
				if (sessionData == null || !sessionData.compare(ApiCodeEnum.OK)) {
					response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.UNAUTHORIZED)));
					return false;
				}
				/* 获取用户ID */
				// uid = sessionData.getData().getCache().get(USER_FLAG);
				/* 这里进行具体的业务权限判断 */
				switch (authentication.level()) {
				/* 角色判断 */
				case ROLE:
					/* TODO 这里应通过权限服务器获取该用户是否具有authentication的角色 */
					// JsonApi<Map<String, Object>> role = 这里远程获取;
					JsonApi<Map<String, Object>> role = new JsonApi<Map<String, Object>>();
					/* 角色不等于空并且请求数据有返回则认为具备权限 实际业务需要注意该远程方法的返回值 */
					if (role != null && role.compare(ApiCodeEnum.OK)) {
						if (role.getData() != null && role.getData().size() > 0) {
							return true;
						}
					}
					response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.UNAUTHORIZED)));
					return false;
				case PERMISSION:
					/* TODO 这里应通过权限服务器获取该用户是否具有authentication的权限 */
					// JsonApi<Map<String, Object>> permission = 这里远程获取;
					JsonApi<Map<String, Object>> permission = new JsonApi<Map<String, Object>>();
					/* 权限不等于空并且请求数据有返回则认为具备权限 实际业务需要注意该远程方法的返回值 */
					if (permission != null && permission.compare(ApiCodeEnum.OK)) {
						if (permission.getData() != null && permission.getData().size() > 0) {
							return true;
						}
					}
					response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.UNAUTHORIZED)));
					return false;
				case OPERATION:
					/* TODO 这里应通过权限服务器获取该用户是否具有operation操作的权限 */
					// JsonApi<Map<String, Object>> operation = 这里远程获取;
					JsonApi<Map<String, Object>> operation = new JsonApi<Map<String, Object>>();
					if (operation != null && operation.compare(ApiCodeEnum.OK)) {
						if (operation.getData() != null && operation.getData().size() > 0) {
							return true;
						}
					}
					response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.UNAUTHORIZED)));
					return false;
				}
			}
			if (logger.isInfoEnabled()) {
				logger.info("access target method [{}#{}] has no permissions", className, methodName);
			}
			response.getWriter().write(om.writeValueAsString(new JsonApi<>(ApiCodeEnum.FORBIDDEN)));
			return false;
		}
		return true;
	}
}
