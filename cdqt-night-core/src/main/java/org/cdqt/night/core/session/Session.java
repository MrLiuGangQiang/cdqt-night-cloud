package org.cdqt.night.core.session;

import java.io.Serializable;

/**
 * 用户登录信息缓存对象
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public class Session<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 唯一区别串
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private String identify;
	/**
	 * 缓存数据
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private T data;

	/**
	 * 无参构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public Session() {
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param identify 唯一区别串
	 * @param data     缓存数据
	 */
	public Session(String identify, T data) {
		this.identify = identify;
		this.data = data;
	}

	/**
	 * @return the identify
	 */
	public String getIdentify() {
		return identify;
	}

	/**
	 * @param identify the identify to set
	 */
	public void setIdentify(String identify) {
		this.identify = identify;
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
