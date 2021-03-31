package com.vicente.exploringspring;

import com.vicente.exploringspring.movie.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
	public List<Movie> hello() {
		return List.of(
			new Movie(1L, "The Martian", "An astronaut left on Mars", LocalDate.of(2015, Month.SEPTEMBER, 11), 6)
		);
	}
}
