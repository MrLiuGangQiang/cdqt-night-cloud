package org.cdqt.night.core.result;

import java.beans.Transient;
import java.io.Serializable;

/**
 * 请求响应通用对象
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public class ResultSet<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 默认资源文件路径
	 *
	 * @author LiuGangQiang Create in 2020/04/02
	 */
	private static final String path = "i18n.core";

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
	 * 参数数组
	 *
	 * @author LiuGangQiang Create in 2020/04/02
	 */
	private Object[] args;

	/**
	 * 是否使用默认资源
	 *
	 * @author LiuGangQiang Create in 2020/04/02
	 */
	private Boolean isDefault;

	/**
	 * 无参构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public ResultSet() {
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 */
	public ResultSet(CodeEnum codeEnum) {
		this.isDefault = true;
		this.code = codeEnum.getValue();
		this.msg = codeEnum.getMessage();
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 * @param data 数据
	 */
	public ResultSet(CodeEnum codeEnum, T data) {
		this.isDefault = true;
		this.data = data;
		this.code = codeEnum.getValue();
		this.msg = codeEnum.getMessage();
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code    自定义状态码
	 * @param message 提示消息
	 */
	public ResultSet(int code, String message) {
		this.isDefault=false;
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
	public ResultSet(int code, String message, T data) {
		this.isDefault=false;
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
	 * @return {@link ResultSet}
	 */
	public ResultSet<T> setCode(Integer code) {
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
	 * @return {@link ResultSet}
	 */
	public ResultSet<T> setData(T data) {
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
	 * @return {@link ResultSet}
	 */
	public ResultSet<T> setMsg(String msg) {
		this.isDefault=false;
		this.msg = msg;
		return this;
	}

	/**
	 * @param msg the msg to set
	 * @return {@link ResultSet}
	 */
	public ResultSet<T> setMsg(String msg, Object... args) {
		this.isDefault=false;
		this.msg = msg;
		this.args = args;
		return this;
	}

	/**
	 * @return the args
	 */
	@Transient
	public Object[] getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(Object[] args) {
		this.args = args;
	}

	/**
	 * @return the isDefault
	 */
	@Transient
	public Boolean getIsDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault the isDefault to set
	 */
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return the path
	 */
	public static String getPath() {
		return path;
	}

	/**
	 * 比较两个状态码是否一致
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 * @return 是否一致
	 */
	public boolean compare(CodeEnum code) {
		return getCode() == code.getValue();
	}
}
