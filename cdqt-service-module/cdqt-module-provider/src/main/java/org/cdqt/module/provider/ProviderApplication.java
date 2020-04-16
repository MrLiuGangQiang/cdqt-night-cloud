package org.cdqt.module.provider;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProviderApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
