package com.example.restservice;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private static final String SECRET_PASSWORD = "letMeIn!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		verifyAdmin(SECRET_PASSWORD);
		return new Greeting(counter.incrementAndGet(), String.format(template, name ));
	}
	
	private int verifyAdmin(String password) {
		if (!password.equals("Mew!")) {
		return(0)
		}
		//Diagnostic Mode
		return(1);
	}
}
