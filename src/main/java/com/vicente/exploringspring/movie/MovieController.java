// API Layer -> provides endpoints. This class has all the resources for the API

package com.vicente.exploringspring.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation makes this class serve RESTful endpoints
@RequestMapping(path = "api/v1/movie") // Instead of 'localhost:8080', now it is 'localhost:8080/path'
public class MovieController {

    private final MovieService movieService; // We tell that this is a class that has to be instanciated, i.e., that is has to be a Spring Bean by using @Service/@Component notation on MovieService

    @Autowired // We are saying that this MovieService above^ should be autowired for us. It should be "magically" instanciated and then injected on the constructor below (movieService)
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
        // this.movieService = new MovieService(); // Use dependency injection to avoid this
    }

    // RESTful endpoint that returns a JSON
	@GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }
}
