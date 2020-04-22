package org.cdqt.night.core.result;

/**
 * 请求响应状态枚举
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public enum ApiStatus {
	/**
	 * 成功状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	OK(200, "night.api.code.ok"),

	/**
	 * 失败状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	FAIL(202, "night.api.code.fail"),

	/**
	 * 参数有误状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	BAD_REQUEST(400, "night.api.code.bad.request"),

	/**
	 * 未登录状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	UNAUTHORIZED(401, "night.api.code.unauthorized"),

	/**
	 * 无权限状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	FORBIDDEN(403, "night.api.code.forbidden"),

	/**
	 * 数据未找到状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	DATA_NOT_FOUND(404, "night.api.code.data.not.found"),

	/**
	 * 方法找不到状态码
	 *
	 * @author LiuGangQiang Create in 2020/04/20
	 */
	METHOD_NOT_FOUND(404, "night.api.code.method.not.found"),

	/**
	 * 方法不允许状态码
	 *
	 * @author LiuGangQiang Create in 2020/04/20
	 */
	METHOD_NOT_ALLOWED(405, "night.api.code.method.not.allowed"),

	/**
	 * 数据冲突状态码（适用于新增时违反逻辑约束产生重复记录）
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	CONFLICT(409, "night.api.code.conflict"),

	/**
	 * 系统异常状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	ERROR(500, "night.api.code.error"),

	/**
	 * 方法不安全状态码 系统内多指为经过权限验证的方法
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	UNIMPLEMENTED(501, "night.api.code.unimplemented"),

	/**
	 * 网关超时状态码（适用于微服务网关或服务间调用）
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	TIMEOUT(504, "night.api.code.timeout");

	/**
	 * 状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private int value;
	/**
	 * 提示消息
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private String key;

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param value 状态码
	 * @param key   提示消息
	 */
	ApiStatus(int value, String key) {
		this.value = value;
		this.key = key;
	}
}