package org.cdqt.night.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

/**
 * SecuritySecureConfig 权限【配置
 *
 * @author LiuGangQiang Create in 2020/01/20
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

	/**
	 * adminContextPath
	 *
	 * @author LiuGangQiang Create in 2020/02/29
	 */
	private final String adminContextPath;

	/**
	 * SecuritySecureConfig
	 *
	 * @author LiuGangQiang Create in 2020/02/29
	 * @param adminServerProperties
	 */
	public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
		this.adminContextPath = adminServerProperties.getContextPath();
	}

	/**
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");
		/* 配置权限 */
		http.authorizeRequests()
				/* 放行资源文件 */
				.antMatchers(adminContextPath + "/assets/**").permitAll()
				/* 放行登录请求 */
				.antMatchers(adminContextPath + "/login").permitAll()
				/* 其他任意请求都需要认证 */
				.anyRequest().authenticated()
				/* 开启formLogin配置 */
				.and().formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler)
				/* 开启logout配置 */
				.and().logout().logoutUrl(adminContextPath + "/logout")
				/* 开启httpBasic认证 */
				.and().httpBasic()
				/* 禁用csrf保护 */
				.and().csrf().disable();
	}
}