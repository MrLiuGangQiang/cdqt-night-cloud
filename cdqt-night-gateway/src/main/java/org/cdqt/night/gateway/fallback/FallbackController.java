package org.cdqt.night.gateway.fallback;

import org.cdqt.night.core.message.Prompt;
import org.cdqt.night.core.result.ApiCodeEnum;
import org.cdqt.night.core.result.JsonApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局断路器
 * 
 * @author LiuGangQiang Create in 2020/01/21
 */
@RestController
public class FallbackController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FallbackController.class);
	/**
	 * PATH 资源路径
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 */
	private static final String PATH = "i18n.night_gateway";

	/**
	 * 处理所有断路请求
	 *
	 * @author LiuGangQiang Create in 2020/01/21
	 * @param lb 服务实例
	 * @return 提示信息
	 */
	@RequestMapping("/fallback/{lb}")
	public JsonApi<?> fallback(@PathVariable("lb") String lb) {
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("server instance [{}] tigger hystrix", lb);
		}
		return new JsonApi<>(ApiCodeEnum.TIMEOUT).setMsg(Prompt.bundle(PATH, "fallback.timeout", lb));
	}
}