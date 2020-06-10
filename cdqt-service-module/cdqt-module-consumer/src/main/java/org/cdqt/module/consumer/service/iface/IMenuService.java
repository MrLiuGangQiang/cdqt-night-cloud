package org.cdqt.module.consumer.service.iface;

import org.cdqt.module.consumer.entity.Menu;
import org.cdqt.module.consumer.service.config.FeignConfig;
import org.cdqt.module.consumer.service.fallback.MenuServiceFallback;
import org.cdqt.night.core.result.ResultApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * IMenuService
 *
 * @author LiuGangQiang Create in 2020/04/16
 */
@FeignClient(name = "${feign.client.provider}", fallback = MenuServiceFallback.class, configuration = FeignConfig.class)
public interface IMenuService {
	@RequestMapping(value = "/menus", method = RequestMethod.POST)
	ResultApi<?> insert(@RequestBody Menu menu);

	@RequestMapping(value = "/menus/{id}", method = RequestMethod.DELETE)
	ResultApi<?> delete(@PathVariable("id") String id);

	@RequestMapping(value = "/menus/{id}", method = RequestMethod.PUT)
	ResultApi<?> update(@PathVariable("id") String id, @RequestBody Menu menu);

	@RequestMapping(value = "/menus/{id}", method = RequestMethod.GET)
	ResultApi<?> queryOne(@PathVariable("id") String id);

	@RequestMapping(value = "/menus", method = RequestMethod.GET)
	ResultApi<?> queryList(@SpringQueryMap Menu menu);

}
