package org.cdqt.module.docs;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DocsApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DocsApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
