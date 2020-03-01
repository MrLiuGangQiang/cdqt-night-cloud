package org.cdqt.night.gateway;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 程序主入口类
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
@SpringCloudApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GatewayApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}