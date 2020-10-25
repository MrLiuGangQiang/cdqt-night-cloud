package org.cdqt.module.security.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cdqt.module.security.entity.Menu;
import org.cdqt.module.security.service.iface.IMenuService;
import org.cdqt.night.core.auth.Authentication;
import org.cdqt.night.core.auth.Level;
import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.ResultApi;
import org.cdqt.night.core.result.Rows;
import org.cdqt.night.core.valid.ValidGroup.Delete;
import org.cdqt.night.core.valid.ValidGroup.Insert;
import org.cdqt.night.core.valid.ValidGroup.QueryList;
import org.cdqt.night.core.valid.ValidGroup.QueryOne;
import org.cdqt.night.core.valid.ValidGroup.Update;
import org.cdqt.night.tools.code.UUIDUtil;
import org.cdqt.night.tools.valid.IntegerUtils;
import org.cdqt.night.tools.valid.ListUtils;
import org.cdqt.night.tools.valid.MapUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
		/* 先校验菜单信息是否存在 */
		Map<String, Object> menuMap = menuService.queryUnique(menu);
		if (MapUtils.isNotEmpty(menuMap)) {
			return new ResultApi<>(ApiStatus.CONFLICT);
		}
		/* 设置主键及其他默认值 */
		menu.setId(UUIDUtil.uuid());
		Date now = new Date();
		menu.setUpdateTime(now);
		menu.setCreateTime(now);
		/* 不存在新增菜单 */
		Integer row = menuService.insert(menu);
		if (IntegerUtils.isGtZero(row)) {
			/* 受影响行数大于零证明新增成功 */
			return new ResultApi<>(ApiStatus.OK);
		} else {
			/* 受影响行数不大于零证明新增失败 */
			return new ResultApi<>(ApiStatus.FAIL);
		}
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
		/* 设置主键 */
		menu.setId(id);
		/* 查询菜单信息是否存在 */
		Map<String, Object> menuMap = menuService.queryOne(menu);
		if (MapUtils.isEmpty(menuMap)) {
			/* 数据不存在提示并返回 */
			return new ResultApi<>(ApiStatus.DATA_NOT_FOUND);
		}
		/* 存在则删除数据 */
		Integer row = menuService.delete(menu);
		if (IntegerUtils.isGtZero(row)) {
			/* 受影响行数大于零证明删除成功 */
			return new ResultApi<>(ApiStatus.OK);
		} else {
			/* 受影响行数不大于零证明删除失败 */
			return new ResultApi<>(ApiStatus.FAIL);
		}
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
		/* 设置主键 */
		menu.setId(id);
		/* 查询菜单信息是否存在 */
		Map<String, Object> menuMap = menuService.queryOne(menu);
		if (MapUtils.isEmpty(menuMap)) {
			/* 数据不存在提示并返回 */
			return new ResultApi<>(ApiStatus.DATA_NOT_FOUND);
		}
		/* 查询菜单信息是否重复 */
		Map<String, Object> menuUniqueMap = menuService.queryUnique(menu);
		if (MapUtils.isNotEmpty(menuUniqueMap)) {
			/* 数据存在提示并返回 */
			return new ResultApi<>(ApiStatus.CONFLICT);
		}
		/* 存在且不冲突则修改数据 */
		Integer row = menuService.update(menu);
		if (IntegerUtils.isGtZero(row)) {
			/* 受影响行数大于零证明修改成功 */
			return new ResultApi<>(ApiStatus.OK);
		} else {
			/* 受影响行数不大于零证明修改失败 */
			return new ResultApi<>(ApiStatus.FAIL);
		}
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
		/* 设置主键 */
		menu.setId(id);
		/* 查询菜单信息是否存在 */
		Map<String, Object> menuMap = menuService.queryOne(menu);
		if (MapUtils.isNotEmpty(menuMap)) {
			/* 数据存在返回数据 */
			return new ResultApi<>(ApiStatus.OK, menuMap);
		} else {
			/* 数据不存在返回数据未找到 */
			return new ResultApi<>(ApiStatus.DATA_NOT_FOUND);
		}
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
		/* 设置分页参数 */
		Page<?> page = PageHelper.startPage(menu.getPage(), menu.getPageSize());
		/* 执行分页查询 */
		List<Map<String, Object>> menuList = menuService.queryList(menu);
		if (ListUtils.isNotEmpty(menuList)) {
			/* 数据存在返回数据 */
			return new ResultApi<>(ApiStatus.OK, new Rows<>(page.getTotal(), menuList));
		} else {
			/* 数据不存在返回数据未找到 */
			return new ResultApi<>(ApiStatus.DATA_NOT_FOUND);
		}
	}
}
