package com.example.spring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Spring2Application {

	public static void main(String[] args) {
		final var context = SpringApplication.run(Spring2Application.class, args);
		System.out.println(context.getBean("connectionPool"));
		System.out.println(context.getBean("companyRepository"));
		System.out.println(context);
	}

}
