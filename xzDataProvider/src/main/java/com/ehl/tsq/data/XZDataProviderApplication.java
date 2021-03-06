package com.ehl.tsq.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource(value = {"classpath:config/application.yml"},
		ignoreResourceNotFound = true)
@MapperScan("com.ehl.tsq.data.infrastructure.persistence.mapper")
@EnableScheduling
public class XZDataProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(XZDataProviderApplication.class, args);
	}

}
