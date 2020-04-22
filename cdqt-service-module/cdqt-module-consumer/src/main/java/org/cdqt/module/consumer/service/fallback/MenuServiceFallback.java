package org.cdqt.module.consumer.service.fallback;

import org.cdqt.module.consumer.entity.Menu;
import org.cdqt.module.consumer.service.iface.IMenuService;
import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.ResultApi;
import org.springframework.stereotype.Component;

/**
 * MenuService
 *
 * @author LiuGangQiang Create in 2020/04/16
 */
@Component
public class MenuServiceFallback implements IMenuService {

	@Override
	public ResultApi<?> insert(Menu menu) {
		return new ResultApi<>(ApiStatus.TIMEOUT);
	}

	@Override
	public ResultApi<?> delete(String id) {
		return new ResultApi<>(ApiStatus.TIMEOUT);
	}

	@Override
	public ResultApi<?> update(String id, Menu menu) {
		return new ResultApi<>(ApiStatus.TIMEOUT);
	}

	@Override
	public ResultApi<?> queryOne(String id) {
		return new ResultApi<>(ApiStatus.TIMEOUT);
	}

	@Override
	public ResultApi<?> queryList(Menu menu) {
		return new ResultApi<>(ApiStatus.TIMEOUT);
	}

}
