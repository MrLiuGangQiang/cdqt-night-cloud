package org.cdqt.night.gateway.fallback;

import java.util.Locale;

import org.cdqt.night.core.result.ApiStatus;
import org.cdqt.night.core.result.Prompt;
import org.cdqt.night.core.result.ResultApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	private static final String PATH = "i18n.gateway";

	/**
	 * 异常断路处理器
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @param lb 服务实例名
	 * @return {@link ResultApi} 对象
	 */
	@RequestMapping("/fallback")
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultApi<?> fallback(@RequestParam("lb") String lb) {
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("server instance [{}] tigger hystrix", lb);
		}
		return new ResultApi<>(ApiStatus.TIMEOUT).setMsg(Prompt.bundle(PATH, Locale.getDefault(), "fallback.timeout", lb));
	}
}