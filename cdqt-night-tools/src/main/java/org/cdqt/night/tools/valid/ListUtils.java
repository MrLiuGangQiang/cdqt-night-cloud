package org.cdqt.night.tools.valid;

import java.util.List;

/**
 * List工具类
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class ListUtils {
	/**
	 * 校验List是否为Null或者无数据
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param list List对象
	 * @return {@link Boolean} 是否为Null或者无数据
	 */
	public static boolean isEmpty(final List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * 校验List是否不为Null且存在数据
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param list List对象
	 * @return {@link Boolean} 是否不为Null且存在数据
	 */
	public static boolean isNotEmpty(final List<?> list) {
		return !ListUtils.isEmpty(list);
	}
}
