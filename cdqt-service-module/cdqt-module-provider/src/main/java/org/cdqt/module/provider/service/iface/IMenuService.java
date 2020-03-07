package org.cdqt.module.provider.service.iface;

import java.util.Map;

import org.cdqt.module.provider.entity.Menu;

/**
 * 菜单Service接口
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public interface IMenuService {

	/**
	 * 获取重复菜单
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param menu 菜单实例
	 * @return {@link Map} 菜单记录
	 */
	Map<String, Object> getRepeat(Menu menu);

	/**
	 * 新增菜单
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param menu 菜单实例
	 * @return {@link Integer} 受影响行数
	 */
	Integer insert(Menu menu);

}
