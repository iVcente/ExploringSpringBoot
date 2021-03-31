// API Layer

package com.vicente.exploringspring.movie;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class has all the resources for the API
@RestController // This annotation makes this class serve RESTful endpoints
@RequestMapping(path = "api/v1/movie") // Instead of 'localhost:8080', now it is 'localhost:8080/path'
public class MovieController {

    // RESTful endpoint to return a JSON
	@GetMapping
	public List<Movie> getMovies() {
		return List.of(
			new Movie(1L, "The Martian", "An astronaut left on Mars", LocalDate.of(2015, Month.SEPTEMBER, 11), 6)
		);
	}
}
