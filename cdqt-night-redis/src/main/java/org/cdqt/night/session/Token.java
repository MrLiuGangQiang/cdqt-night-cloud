package org.cdqt.night.session;

import java.io.Serializable;
import java.util.Base64;
import java.util.UUID;

/**
 * Token操作类
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public class Token implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 私有化构造器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private Token() {
	}

	/**
	 * 内部工具类
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private static class SingleTokenHolder {
		/**
		 * {@link Token} 静态常量实例
		 *
		 * @author LiuGangQiang Create in 2020/03/01
		 */
		private final static Token INSTANCE = new Token();
	}

	/**
	 * 懒加载获取实例
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @return {@link SingleTokenHolder#INSTANCE} 实例
	 */
	public static Token getInstance() {
		return SingleTokenHolder.INSTANCE;
	}

	/**
	 * 通过String创建Token
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param terminal 平台标识枚举
	 * @param identify 唯一区别串（这里传记录主键或唯一标识记录的数据即可）
	 * @return 组合并经过Base64加密的唯一Token
	 */
	public String createToken(TerminalEnum terminal, String identify) {
		StringBuffer token = new StringBuffer();
		token.append(terminal.getFlag()).append(":");
		token.append(UUID.randomUUID()).append(":");
		token.append(identify);
		return Base64.getEncoder().encodeToString(token.toString().getBytes());
	};

	/**
	 * 通过Long创建Token
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param terminal 平台标识枚举
	 * @param identify 唯一区别串（这里传记录主键或唯一标识记录的数据即可）
	 * @return 组合并经过Base64加密的唯一Token
	 */
	public String createToken(TerminalEnum terminal, Long identify) {
		StringBuffer token = new StringBuffer();
		token.append(terminal.getFlag()).append(":");
		token.append(UUID.randomUUID()).append(":");
		token.append(identify);
		return Base64.getEncoder().encodeToString(token.toString().getBytes());
	};

	/**
	 * Token解码
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param token 加密前的字符串
	 * @return 解码后的字符串
	 */
	public String decodeToekn(String token) {
		String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
		if (token.matches(base64Pattern)) {
			return new String(Base64.getDecoder().decode(token.getBytes()));
		} else {
			throw new RuntimeException("it's not legal token");
		}
	}
}
