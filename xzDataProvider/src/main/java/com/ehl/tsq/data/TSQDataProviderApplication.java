package com.ehl.tsq.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:config/application.yml", "classpath:config/system-dev.yml"},
		ignoreResourceNotFound = true)
public class TSQDataProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TSQDataProviderApplication.class, args);
	}

}
