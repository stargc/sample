package com.ehl.ambari.metric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@PropertySource(value = {"classpath:config/application.properties"},
		ignoreResourceNotFound = true)
@EnableScheduling
public class TpsWorkbenchApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpsWorkbenchApplication.class, args);
	}

}
