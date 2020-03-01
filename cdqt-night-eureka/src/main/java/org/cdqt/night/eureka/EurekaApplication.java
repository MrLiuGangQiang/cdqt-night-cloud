package org.cdqt.night.eureka;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 应用程序主入口类
 *
 * @author LiuGangQiang Create in 2020/03/01
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EurekaApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
