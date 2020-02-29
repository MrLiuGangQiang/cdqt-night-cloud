package org.cdqt.night.admin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * AdminApplication
 *
 * @author LiuGangQiang Create in 2020/02/29
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminApplication {
	/**
	 * main 启动函数
	 *
	 * @author LiuGangQiang Create in 2020/02/29
	 * @param args args
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AdminApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}