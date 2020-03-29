package org.cdqt.module.provider.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.cdqt.module.provider.entity.Menu;
import org.cdqt.module.provider.mapper.MenuMapper;
import org.cdqt.module.provider.service.iface.IMenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单Service
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
@Service
public class MenuService implements IMenuService {
	@Resource
	private MenuMapper menuMapper;

	/**
	 * @see org.cdqt.module.provider.service.iface.IMenuService#getRepeat(org.cdqt.module.provider.entity.Menu)
	 */
	@Override
	public Map<String, Object> getRepeat(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.cdqt.module.provider.service.iface.IMenuService#insert(org.cdqt.module.provider.entity.Menu)
	 */
	@Override
	public Integer insert(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

}
