// Service Layer -> mainly responsible for business logic

package com.vicente.exploringspring.movie;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Used alongside with @Autowired so that it knows where to find the class/object it needs to inject
@Service // @Service and @Component are the same. @Service is used here as we don't want this to be just a regular component, we want it to be a service. Semantics and readability purpose pretty much
public class MovieService {

	private final MovieRepository movieRepository;

	@Autowired // Dependency injection once again
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository; 
	}

    public List<Movie> getMovies() {
		return movieRepository.findAll(); // Spring JPA magic, interface implemented
		// return List.of(new Movie(1L, "The Martian", "An astronaut left on Mars", LocalDate.of(2015, Month.SEPTEMBER, 11), 6)); // Old way of doing it without the database and JPA
	}
}
