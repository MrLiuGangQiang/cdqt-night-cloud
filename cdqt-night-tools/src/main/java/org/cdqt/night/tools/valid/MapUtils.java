package org.cdqt.night.tools.valid;

import java.util.Map;

/**
 * Map工具类
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class MapUtils {
	/**
	 * 校验Map是否为Null或者无数据
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param map Map对象
	 * @return {@link Boolean} 是否为Null或者无数据
	 */
	public static boolean isEmpty(final Map<?, ?> map) {
		return map == null || map.isEmpty();
	}

	/**
	 * 校验Map是否不为Null且存在数据
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param map Map对象
	 * @return {@link Boolean} 是否不为Null且存在数据
	 */
	public static boolean isNotEmpty(final Map<?, ?> map) {
		return !MapUtils.isEmpty(map);
	}
}
