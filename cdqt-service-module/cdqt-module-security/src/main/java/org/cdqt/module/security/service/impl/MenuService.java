package org.cdqt.module.security.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cdqt.module.security.entity.Menu;
import org.cdqt.module.security.mapper.MenuMapper;
import org.cdqt.module.security.service.iface.IMenuService;
import org.springframework.stereotype.Service;

/**
 * MenuService
 *
 * @author LiuGangQiang Create in 2020/04/06
 */
@Service
public class MenuService implements IMenuService {
	@Resource
	private MenuMapper mapper;

	/**
	 * @see org.cdqt.module.security.service.iface.IMenuService#queryUnique(org.cdqt.module.security.entity.Menu)
	 */
	@Override
	public Map<String, Object> queryUnique(Menu menu) {
		return mapper.queryUnique(menu);
	}

	/**
	 * @see org.cdqt.module.security.service.iface.IMenuService#insert(org.cdqt.module.security.entity.Menu)
	 */
	@Override
	public Integer insert(Menu menu) {
		return mapper.insert(menu);
	}

	/**
	 * @see org.cdqt.module.security.service.iface.IMenuService#queryOne(org.cdqt.module.security.entity.Menu)
	 */
	@Override
	public Map<String, Object> queryOne(Menu menu) {
		return mapper.queryOne(menu);
	}

	/**
	 * @see org.cdqt.module.security.service.iface.IMenuService#delete(org.cdqt.module.security.entity.Menu)
	 */
	@Override
	public Integer delete(Menu menu) {
		return mapper.delete(menu);
	}

	/**
	 * @see org.cdqt.module.security.service.iface.IMenuService#update(org.cdqt.module.security.entity.Menu)
	 */
	@Override
	public Integer update(Menu menu) {
		return mapper.update(menu);
	}

	/**
	 * @see org.cdqt.module.security.service.iface.IMenuService#queryList(org.cdqt.module.security.entity.Menu)
	 */
	@Override
	public List<Map<String, Object>> queryList(Menu menu) {
		return mapper.queryList(menu);
	}

}
