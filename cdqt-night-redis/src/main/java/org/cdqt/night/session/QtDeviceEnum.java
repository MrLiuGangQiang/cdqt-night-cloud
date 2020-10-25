package org.cdqt.night.session;

/**
 * 操作平台枚举
 * 
 * @author LiuGangQiang Create in 2020/03/01
 */
public enum QtDeviceEnum {
	/**
	 * Web端标识
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	WEB("web"),
	/**
	 * Android端标识
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	ANDROID("android"),
	/**
	 * IOS端标识
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	IOS("ios"),
	/**
	 * Box端标识（机顶盒、游戏盒子等）
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	BOX("box"),
	/**
	 * Mobile端标识（包括Android、IOS等）
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	MOBILE("mobile"),
	/**
	 * Wecaht端标识
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	WECHAT("wechat");

	/**
	 * 终端标识
	 *
	 * @author LiuGangQiang Create in 2020/03/01
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
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param falg 终端标识
	 */
	QtDeviceEnum(String falg) {
		this.flag = falg;
	}
}