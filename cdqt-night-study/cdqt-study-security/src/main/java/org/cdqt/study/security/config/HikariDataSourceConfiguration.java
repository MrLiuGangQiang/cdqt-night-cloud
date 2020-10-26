package org.cdqt.study.security.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据库连接池配置
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
@Configuration
public class HikariDataSourceConfiguration {
	/**
	 * 实例化 {@link DataSource} 对象
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @return {@link DataSource} 对象
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource hikariDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		return dataSource;
	}
}