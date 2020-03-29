package org.cdqt.night.gateway.fallback;

import java.util.Locale;

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
 * @author LiuGangQiang Create in 2020/03/01
 */
@RestController
public class FallbackController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FallbackController.class);
	/**
	 * 提示资源文件路径 值为 {@value}
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 */
	private static final String PATH = "i18n.night_gateway";

	/**
	 * 异常断路处理器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param lb 服务实例名
	 * @return {@link JsonApi} 对象
	 */
	@RequestMapping("/fallback/{lb}")
	public JsonApi<?> fallback(@PathVariable("lb") String lb) {
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("server instance [{}] tigger hystrix", lb);
		}
		return new JsonApi<>(ApiCodeEnum.TIMEOUT).setMsg(Prompt.bundle(PATH, "fallback.timeout", Locale.getDefault(), lb));
	}
}