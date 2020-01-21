package org.cdqt.night.core.session;

/**
 * 操作平台枚举
 * 
 * @author LiuGangQiang Create in 2020/01/21
 */
public enum TerminalEnum {
	/**
	 * Web端标识
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	WEB("web"),
	/**
	 * Android端标识
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	ANDROID("android"),
	/**
	 * Ios端标识
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	IOS("ios"),
	/**
	 * Box端标识（机顶盒、游戏盒子等）
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	BOX("box"),
	/**
	 * Mobile端标识（包括Android、Ios等）
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	MOBILE("mobile"),
	/**
	 * Wecaht端标识
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	WECHAT("wechat");
	/**
	 * 终端标识
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	private String flag;

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 构造器
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 * @param falg 终端标识
	 */
	TerminalEnum(String falg) {
		this.flag = falg;
	}
}