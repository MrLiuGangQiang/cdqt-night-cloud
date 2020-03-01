package org.cdqt.night.eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 权限认证配置
 *
 * @author LiuGangQiang Create in 2020/03/01
 */
@EnableWebSecurity
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

	/**
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* 关闭CSRF */
		http.csrf().disable();
		/* 开启认证 */
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

}
