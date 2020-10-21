package org.cdqt.night.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 跨域配置类
 *
 * @author LiuGangQiang Create in 2020/03/01
 */
@Configuration
public class CorsWebConfiguration {
	/**
	 * 跨域配置 注意网关配置了跨域其代理的微服务就不能再配置跨域不然会造成重复跨域的问题
	 *
	 * @author LiuGangQiang Create in 2020/03/01
	 * @return {@link CorsWebFilter} 对象
	 */
	@Bean
	public CorsWebFilter corsWebFilter() {
		CorsConfiguration config = new CorsConfiguration();
		/* 跨域配置 */
		config.setAllowCredentials(Boolean.TRUE);
		config.addAllowedMethod("*");
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.setMaxAge(3600L);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
		source.registerCorsConfiguration("/**", config);
		return new CorsWebFilter(source);
	}
}
