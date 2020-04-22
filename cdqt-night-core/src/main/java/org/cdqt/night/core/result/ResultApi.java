package org.cdqt.night.core.result;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Locale;

/**
 * 请求响应通用对象
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public class ResultApi<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 默认资源文件路径
	 *
	 * @author LiuGangQiang Create in 2020/04/02
	 */
	private static final String DEFAULT_PATH = "i18n.core";

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
	 * 语言环境
	 *
	 * @author LiuGangQiang Create in 2020/04/22
	 */
	transient private Locale locale;
	/**
	 * 资源文件路径
	 *
	 * @author LiuGangQiang Create in 2020/04/22
	 */
	transient private String path;
	/**
	 * 资源文件键值
	 *
	 * @author LiuGangQiang Create in 2020/04/22
	 */
	transient private String key;
	/**
	 * 参数数组
	 *
	 * @author LiuGangQiang Create in 2020/04/02
	 */
	transient private Object[] args;

	/**
	 * 是否使用默认资源
	 *
	 * @author LiuGangQiang Create in 2020/04/02
	 */
	transient private Boolean isDefault;

	/**
	 * 无参构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public ResultApi() {
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 */
	public ResultApi(ApiStatus apiStatus) {
		this.isDefault = true;
		this.code = apiStatus.getValue();
		this.key = apiStatus.getKey();
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 * @param data 数据
	 */
	public ResultApi(ApiStatus apiStatus, T data) {
		this.isDefault = true;
		this.data = data;
		this.code = apiStatus.getValue();
		this.key = apiStatus.getKey();
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code    自定义状态码
	 * @param message 提示消息
	 */
	public ResultApi(int code, String message) {
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
	public ResultApi(int code, String message, T data) {
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
	 * @return {@link ResultApi}
	 */
	public ResultApi<T> setCode(Integer code) {
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
	 * @return {@link ResultApi}
	 */
	public ResultApi<T> setData(T data) {
		this.data = data;
		return this;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		if (this.msg != null) {
			return msg;
		} else {
			if (this.isDefault) {
				return Prompt.bundle(DEFAULT_PATH, getLocale(), this.key);
			} else {
				return Prompt.bundle(getPath(), getLocale(), this.key, this.args);
			}
		}
	}

	/**
	 * @param msg the msg to set
	 * @return {@link ResultApi}
	 */
	public ResultApi<T> setMsg(String msg) {
		this.isDefault = false;
		this.msg = msg;
		return this;
	}

	/**
	 * @return the locale
	 */
	@Transient
	public Locale getLocale() {
		return locale == null ? Locale.getDefault() : locale;
	}

	/**
	 * @param locale the locale to set
	 * @return {@link ResultApi}
	 */
	public ResultApi<T> setLocale(Locale locale) {
		this.locale = locale;
		return this;
	}

	/**
	 * @return the path
	 */
	@Transient
	public String getPath() {
		return path == null ? Prompt.getFilepath() : path;
	}

	/**
	 * @param path the path to set
	 * @return {@link ResultApi}
	 */
	public ResultApi<T> setPath(String path) {
		this.path = path;
		return this;
	}

	/**
	 * @param key the key to set
	 * @return {@link ResultApi}
	 */
	public ResultApi<T> setKey(String key) {
		this.isDefault = false;
		this.key = key;
		return this;
	}

	/**
	 * @param key  the key to set
	 * @param args the args to set
	 * @return {@link ResultApi}
	 */
	public ResultApi<T> setKey(String key, Object... args) {
		this.isDefault = false;
		this.args = args;
		this.key = key;
		return this;
	}

	/**
	 * 比较两个状态码是否一致
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param code 状态枚举
	 * @return 是否一致
	 */
	public boolean compare(ApiStatus code) {
		return getCode() == code.getValue();
	}
}
