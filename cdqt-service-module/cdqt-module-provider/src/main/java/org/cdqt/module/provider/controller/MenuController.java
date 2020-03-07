package org.cdqt.module.provider.controller;

import java.util.Map;

import org.cdqt.module.provider.entity.Menu;
import org.cdqt.module.provider.service.iface.IMenuService;
import org.cdqt.night.core.result.ApiCodeEnum;
import org.cdqt.night.core.result.JsonApi;
import org.cdqt.night.core.valid.ValidGroup.Insert;
import org.cdqt.night.tools.valid.IntegerUtils;
import org.cdqt.night.tools.valid.MapUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 菜单Controller
 *
 * @author LiuGangQiang Create in 2020/03/07
 */
public class MenuController {
	/**
	 * 菜单Service
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 */
	private IMenuService menuService;

	/**
	 * 新增菜单
	 *
	 * @author LiuGangQiang Create in 2020/03/07
	 * @param menu   菜单实例
	 * @param result 校验结果
	 * @return {@link JsonApi}
	 */
	@PostMapping("/menu")
	public JsonApi<?> insert(@Validated({ Insert.class }) @RequestBody Menu menu, BindingResult result) {
		/* 1.判断数据是否重复 */
		Map<String, Object> repeatMap = menuService.getRepeat(menu);
		if (MapUtils.isNotEmpty(repeatMap)) {
			/* 数据重复提示并结束流程 */
			return new JsonApi<>(ApiCodeEnum.CONFLICT);
		}
		/* 2.数据不重复新增数据 */
		Integer row = menuService.insert(menu);
		if (IntegerUtils.isGtZero(row)) {
			/* 新增成功 */
			return new JsonApi<>(ApiCodeEnum.OK);
		}
		/* 新增失败 */
		return new JsonApi<>(ApiCodeEnum.FAIL);
	};
}
