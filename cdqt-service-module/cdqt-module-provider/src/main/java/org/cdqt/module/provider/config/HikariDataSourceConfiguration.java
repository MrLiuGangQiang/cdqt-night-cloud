package org.cdqt.module.provider.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HikariDataSourceConfiguration {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource hikariDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		return dataSource;
	}
}