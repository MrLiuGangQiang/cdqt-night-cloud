package org.cdqt.study.security;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SecurityApplication
 *
 * @author LiuGangQiang Create in 2020/04/05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SecurityApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
