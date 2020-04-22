package org.cdqt.module.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.cdqt.module.provider.entity.Menu;
import org.cdqt.night.core.auth.Authentication;
import org.cdqt.night.core.auth.Level;
import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.ResultApi;
import org.cdqt.night.core.result.Rows;
import org.cdqt.night.core.valid.ValidGroup.Insert;
import org.cdqt.night.core.valid.ValidGroup.QueryList;
import org.cdqt.night.core.valid.ValidGroup.Update;
import org.springframework.beans.factory.annotation.Value;
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
	/**
	 * 端口
	 *
	 * @author LiuGangQiang Create in 2020/04/16
	 */
	@Value("${server.port}")
	private String port;

	/**
	 * 新增菜单
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param menu 菜单对象
	 * @return {@link ResultApi}
	 */
	@PostMapping("/menus")
	@Authentication(value = "role:security:menu:insert", level = Level.ROLE)
	public ResultApi<?> insert(@Validated({ Insert.class }) @RequestBody Menu menu) {
		return new ResultApi<>(ApiStatus.OK, menu).setKey("provider.port", port);
	}

	/**
	 * 删除菜单
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param id   主键
	 * @return {@link ResultApi}
	 */
	@DeleteMapping("/menus/{id}")
	@Authentication(value = "role:security:menu:delete", level = Level.ROLE)
	public ResultApi<?> delete(@PathVariable("id") String id) {
		Menu menu = new Menu();
		menu.setId(id);
		return new ResultApi<>(ApiStatus.OK).setKey("provider.port", port);
	}

	/**
	 * 修改菜单
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param id   主键
	 * @return {@link ResultApi}
	 */
	@PutMapping("/menus/{id}")
	@Authentication(value = "role:security:menu:update", level = Level.ROLE)
	public ResultApi<?> update(@PathVariable("id") String id, @Validated({ Update.class }) @RequestBody Menu menu) {
		menu.setId(id);
		return new ResultApi<>(ApiStatus.OK).setKey("provider.port", port);
	}

	/**
	 * 查询单个菜单信息
	 *
	 * @author LiuGangQiang Create in 2020/04/06
	 * @param id 主键
	 * @return {@link ResultApi}
	 */
	@GetMapping("/menus/{id}")
	@Authentication(value = "role:security:menu:query-one", level = Level.ROLE)
	public ResultApi<?> queryOne(@PathVariable("id") String id) {
		Menu menu = new Menu();
		menu.setId(id);
		return new ResultApi<>(ApiStatus.OK, menu).setKey("provider.port", port);
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
		List<Menu> list = new ArrayList<Menu>();
		list.add(menu);
		return new ResultApi<>(ApiStatus.OK, new Rows<>(1, list)).setKey("provider.port", port);
	}
}
