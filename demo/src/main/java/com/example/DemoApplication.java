package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		String password = "Apple";
		System.out.println("Password"+ password);
		SpringApplication.run(DemoApplication.class, args);
	}
}
