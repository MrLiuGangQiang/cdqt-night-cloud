package org.cdqt.night.core.result;

import java.io.Serializable;

/**
 * 请求响应通用对象
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public class JsonApi<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 状态码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private Integer code;

	/**
	 * 数据
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private T data;

	/**
	 * 提示消息
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private String msg;

	/**
	 * 无参构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public JsonApi() {
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 */
	public JsonApi(ApiCodeEnum code) {
		this.data = null;
		this.code = code.getValue();
		this.msg = code.getMessage();
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 * @param data 数据
	 */
	public JsonApi(ApiCodeEnum code, T data) {
		this.data = data;
		this.code = code.getValue();
		this.msg = code.getMessage();
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code    自定义状态码
	 * @param message 提示消息
	 */
	public JsonApi(int code, String message) {
		this.data = null;
		this.code = code;
		this.msg = message;
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code    自定义状态码
	 * @param message 提示消息
	 * @param data    数据
	 */
	public JsonApi(int code, String message, T data) {
		this.data = null;
		this.code = code;
		this.msg = message;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 * @return {@link JsonApi}
	 */
	public JsonApi<T> setCode(Integer code) {
		this.code = code;
		return this;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 * @return {@link JsonApi}
	 */
	public JsonApi<T> setData(T data) {
		this.data = data;
		return this;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 * @return {@link JsonApi}
	 */
	public JsonApi<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	/**
	 * 比较两个状态码是否一致
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 * @return 是否一致
	 */
	public boolean compare(ApiCodeEnum code) {
		return getCode() == code.getValue();
	}
}
