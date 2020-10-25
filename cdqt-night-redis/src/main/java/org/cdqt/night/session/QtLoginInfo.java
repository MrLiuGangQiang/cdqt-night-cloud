package org.cdqt.night.session;

import java.io.Serializable;

/**
 * 通用登录信息
 *
 * @author LiuGangQiang Create in 2020/10/25
 */
@SuppressWarnings("serial")
public class QtLoginInfo<T> implements Serializable {
	/**
	 * 返回给客户端的Token
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 */
	private String token;
	/**
	 * 登录用户信息
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 */
	private T data;

	/**
	 * 无参构造器
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 */
	public QtLoginInfo() {
		super();
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 * @param token token
	 * @param data  用户数据
	 */
	public QtLoginInfo(String token, T data) {
		super();
		this.token = token;
		this.data = data;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

}
