package org.cdqt.night.session;

import java.io.Serializable;

/**
 * 用户登录信息缓存对象
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public class QtSession<T> implements Serializable {

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
	private T cache;

	/**
	 * 无参构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	public QtSession() {
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param identify 唯一区别串
	 * @param cache    缓存数据
	 */
	public QtSession(String identify, T cache) {
		this.identify = identify;
		this.cache = cache;
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
	 * @return the cache
	 */
	public T getCache() {
		return cache;
	}

	/**
	 * @param data the cache to set
	 */
	public void setCache(T cache) {
		this.cache = cache;
	}
}
