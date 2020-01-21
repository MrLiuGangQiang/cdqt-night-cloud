package org.cdqt.night.core.result;

import org.cdqt.night.core.message.Prompt;

/**
 * 请求响应状态枚举
 * 
 * @author LiuGangQiang Create in 2020/01/21
 */
public enum ApiCodeEnum {

	/**
	 * 成功
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	OK(200, "smile.api.code.ok"),

	/**
	 * 失败
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	FAIL(202, "smile.api.code.fail"),

	/**
	 * 参数有误
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	BAD_REQUEST(400, "smile.api.code.bad.request"),

	/**
	 * 未登录
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	UNAUTHORIZED(401, "smile.api.code.unauthorized"),

	/**
	 * 无权限
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	FORBIDDEN(403, "smile.api.code.forbidden"),

	/**
	 * 数据未找到
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	NOT_FOUND(404, "smile.api.code.not.found"),

	/**
	 * 数据冲突（适用于新增时违反逻辑约束产生重复记录）
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	CONFLICT(409, "smile.api.code.conflict"),

	/**
	 * 系统异常
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	ERROR(500, "smile.api.code.error"),

	/**
	 * 方法不安全 没有经过权限注解验证
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	UNIMPLEMENTED(501, "smile.api.code.unimplemented"),

	/**
	 * 网关超时（适用于微服务网关或服务间调用）
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	TIMEOUT(504, "smile.api.code.timeout");

	/**
	 * 状态码
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	private int value;
	/**
	 * 提示消息
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	private String message;

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 * @param value   状态码
	 * @param message 提示消息
	 */
	ApiCodeEnum(int value, String message) {
		this.value = value;
		this.message = Prompt.bundle("i18n.comlib_core", message);
	}
}