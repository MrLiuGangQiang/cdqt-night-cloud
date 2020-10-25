package org.cdqt.night.session;

import java.io.Serializable;
import java.util.Base64;
import java.util.UUID;

/**
 * QtToken操作类
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public class QtToken implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 私有化构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private QtToken() {
	}

	/**
	 * 内部工具类
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private static class SingleQtTokenHolder {
		/**
		 * {@link QtToken} 静态常量实例
		 *
		 * @author LiuGangQiang Create in 2020/03/01
		 */
		private final static QtToken INSTANCE = new QtToken();
	}

	/**
	 * 懒加载获取实例
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @return {@link SingleQtTokenHolder#INSTANCE} 实例
	 */
	public static QtToken getInstance() {
		return SingleQtTokenHolder.INSTANCE;
	}

	/**
	 * 通过String创建QtToken
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param terminal 平台标识枚举
	 * @param identify 唯一区别串（这里传记录主键或唯一标识记录的数据即可）
	 * @return 组合并经过Base64加密的唯一QtToken
	 */
	public String createQtToken(QtDeviceEnum terminal, String identify) {
		StringBuffer QtToken = new StringBuffer();
		QtToken.append(terminal.getFlag()).append(":");
		QtToken.append(UUID.randomUUID()).append(":");
		QtToken.append(identify);
		return Base64.getEncoder().encodeToString(QtToken.toString().getBytes());
	};

	/**
	 * 通过Long创建QtToken
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param terminal 平台标识枚举
	 * @param identify 唯一区别串（这里传记录主键或唯一标识记录的数据即可）
	 * @return 组合并经过Base64加密的唯一QtToken
	 */
	public String createQtToken(QtDeviceEnum terminal, Long identify) {
		StringBuffer QtToken = new StringBuffer();
		QtToken.append(terminal.getFlag()).append(":");
		QtToken.append(UUID.randomUUID()).append(":");
		QtToken.append(identify);
		return Base64.getEncoder().encodeToString(QtToken.toString().getBytes());
	};

	/**
	 * QtToken解码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param QtToken 加密前的字符串
	 * @return 解码后的字符串
	 */
	public String decodeToekn(String QtToken) {
		String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
		if (QtToken.matches(base64Pattern)) {
			return new String(Base64.getDecoder().decode(QtToken.getBytes()));
		} else {
			throw new RuntimeException("it's not legal token");
		}
	}
}
