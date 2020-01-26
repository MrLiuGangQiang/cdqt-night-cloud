package org.cdqt.module.mongo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * MongodbApplication
 *
 * @author LiuGangQiang Create in 2020/01/24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MongodbApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MongodbApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}