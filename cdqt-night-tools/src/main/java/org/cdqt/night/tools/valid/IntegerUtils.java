package org.cdqt.night.tools.valid;

/**
 * Integer工具类
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class IntegerUtils {

	/**
	 * 校验Integer是否不等于NULL且大于某个数
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @param target  目标数值
	 * @return {@link Boolean} 是否不等于NULL且大于某个数
	 */
	public static boolean isGt(final Integer integer, final int target) {
		return integer != null && integer > target;
	}

	/**
	 * 校验Integer是否不等于NULL且大于0
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @return {@link Boolean} 是否不等于NULL且大于0
	 */
	public static boolean isGtZero(final Integer integer) {
		return integer != null && integer > 0;
	}

	/**
	 * 校验Integer是否不等于NULL且大于等于某个数
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @param target  目标数值
	 * @return {@link Boolean} 是否不等于NULL且大于等于某个数
	 */
	public static boolean isGe(final Integer integer, final int target) {
		return integer != null && integer >= target;
	}

	/**
	 * 校验Integer是否不等于NULL且大于等于0
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @return {@link Boolean} 是否不等于NULL且大于等于0
	 */
	public static boolean isGeZero(final Integer integer) {
		return integer != null && integer >= 0;
	}

	/**
	 * 校验Integer是否不等于NULL且小于某个数
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @param target  目标数值
	 * @return {@link Boolean} 是否不等于NULL且小于某个数
	 */
	public static boolean isLt(final Integer integer, final int target) {
		return integer != null && integer < target;
	}

	/**
	 * 校验Integer是否不等于NULL且小于0
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @return {@link Boolean} 是否不等于NULL且小于0
	 */
	public static boolean isLtZero(final Integer integer) {
		return integer != null && integer < 0;
	}

	/**
	 * 校验Integer是否不等于NULL且小于等于某个数
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @param target  目标数值
	 * @return {@link Boolean} 是否不等于NULL且小于等于某个数
	 */
	public static boolean isLe(final Integer integer, final int target) {
		return integer != null && integer <= target;
	}

	/**
	 * 校验Integer是否不等于NULL且小于等于0
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @return {@link Boolean} 是否不等于NULL且小于等于0
	 */
	public static boolean isLeZero(final Integer integer) {
		return integer != null && integer <= 0;
	}

	/**
	 * 校验Integer是否不等于NULL且等于某个数
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @param target  目标数值
	 * @return {@link Boolean} 是否不等于NULL且等于某个数
	 */
	public static boolean isEq(final Integer integer, final int target) {
		return integer != null && integer == target;
	}

	/**
	 * 校验Integer是否不等于NULL且等于0
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param integer Integer对象
	 * @return {@link Boolean} 是否不等于NULL且等于0
	 */
	public static boolean isEqZero(final Integer integer) {
		return integer != null && integer == 0;
	}
}
