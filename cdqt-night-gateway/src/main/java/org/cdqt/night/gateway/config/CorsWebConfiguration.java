package org.cdqt.night.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * CorsWebConfiguration 跨域配置
 *
 * @author LiuGangQiang Create in 2020/02/25
 */
public class CorsWebConfiguration {
	/**
	 * 配置跨域
	 * @return
	 */
	@Bean
	public CorsWebFilter corsFilter() {
	    CorsConfiguration config = new CorsConfiguration();
	    // cookie跨域
	    config.setAllowCredentials(Boolean.TRUE);
	    config.addAllowedMethod("*");
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.setMaxAge(1800L);
	
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
	    source.registerCorsConfiguration("/**", config);
	
	    return new CorsWebFilter(source);
	}
	
	
}
 
