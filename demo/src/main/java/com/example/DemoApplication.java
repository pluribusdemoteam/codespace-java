package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private String SECRET_PASSWORD = "letMeIn!";

	public static void main(String[] args) {
		System.out.println("SECRET_PASSWORD"+ SECRET_PASSWORD);
		SpringApplication.run(DemoApplication.class, args);
	}
}
