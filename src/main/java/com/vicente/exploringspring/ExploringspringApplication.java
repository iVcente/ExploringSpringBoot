package com.vicente.exploringspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // This annotation makes this class serve RESTful endpoints
public class ExploringspringApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExploringspringApplication.class, args);
	}

	// RESTful endpoint to return a JSON
	@GetMapping
	public String hello() {
		return "Hello, world!";
	}
}
