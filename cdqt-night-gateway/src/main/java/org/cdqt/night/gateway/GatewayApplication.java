package org.cdqt.night.gateway;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * GatewayApplication
 *
 * @author LiuGangQiang Create in 2020/01/21
 */
@SpringCloudApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GatewayApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}