package com.stargc.sample.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:config/application.yml"},
		ignoreResourceNotFound = true)
public class EsSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsSampleApplication.class, args);
	}

}
