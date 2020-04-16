package org.cdqt.module.consumer.controller;

import javax.annotation.Resource;

import org.cdqt.module.consumer.entity.Menu;
import org.cdqt.module.consumer.service.iface.IMenuService;
import org.cdqt.night.core.auth.Authentication;
import org.cdqt.night.core.auth.Level;
import org.cdqt.night.core.result.ResultApi;
import org.cdqt.night.core.valid.ValidGroup.Delete;
import org.cdqt.night.core.valid.ValidGroup.Insert;
import org.cdqt.night.core.valid.ValidGroup.QueryList;
import org.cdqt.night.core.valid.ValidGroup.QueryOne;
import org.cdqt.night.core.valid.ValidGroup.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * MenuController
 *
 * @author LiuGangQiang Create in 2020/04/06
 */
@RestController
public class MenuController {
	@Resource
	private IMenuService menuService;

	/**
	 * 新增菜单
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param menu 菜单对象
	 * @return {@link ResultApi}
	 */
	@PostMapping("/menu")
	@Authentication(value = "role:security:menu:insert", level = Level.ROLE)
	public ResultApi<?> insert(@Validated({ Insert.class }) @RequestBody Menu menu) {
		return menuService.insert(menu);
	}

	/**
	 * 删除菜单
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param id   主键
	 * @param menu 菜单对象
	 * @return {@link ResultApi}
	 */
	@DeleteMapping("/menu/{id}")
	@Authentication(value = "role:security:menu:delete", level = Level.ROLE)
	public ResultApi<?> delete(@PathVariable("id") String id, @Validated({ Delete.class }) Menu menu) {
		return menuService.delete(id, menu);
	}

	/**
	 * 修改菜单
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param id   主键
	 * @param menu 菜单对象
	 * @return {@link ResultApi}
	 */
	@PutMapping("/menu/{id}")
	@Authentication(value = "role:security:menu:update", level = Level.ROLE)
	public ResultApi<?> update(@PathVariable("id") String id, @Validated({ Update.class }) @RequestBody Menu menu) {
		return menuService.update(id, menu);
	}

	/**
	 * 查询单个菜单信息
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param id   主键
	 * @param menu 菜单对象
	 * @return {@link ResultApi}
	 */
	@GetMapping("/menu/{id}")
	@Authentication(value = "role:security:menu:query-one", level = Level.ROLE)
	public ResultApi<?> queryOne(@PathVariable("id") String id, @Validated({ QueryOne.class }) Menu menu) {
		return menuService.queryOne(id, menu);
	}

	/**
	 * 查询多个菜单信息
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param menu 菜单信息
	 * @return {@link ResultApi}
	 */
	@GetMapping("/menus")
	@Authentication(value = "role:security:menu:query-list", level = Level.ROLE)
	public ResultApi<?> queryList(@Validated({ QueryList.class }) Menu menu) {
		return menuService.queryList(menu);
	}
}
