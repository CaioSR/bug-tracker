package com.shimada.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.shimada")
public class Application extends SpringBootServletInitializer {

	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.shimada");
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public static <T> T getInstance(Class<T> type) {
		return context.getBean(type);
	}

}
