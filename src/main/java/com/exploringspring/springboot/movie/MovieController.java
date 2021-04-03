// API Layer -> provides endpoints. This class has all the resources for the API

package com.exploringspring.springboot.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation makes this class serve RESTful endpoints
@RequestMapping(path = "api/movie") // Instead of 'localhost:8080', now it is 'localhost:8080/path'
public class MovieController {

    private final MovieService movieService; // We tell that this is a class that has to be instanciated, i.e., that is has to be a Spring Bean by using @Service/@Component annotation on MovieService

    @Autowired // We are saying that this MovieService above^ should be autowired for us. It should be "magically" instanciated and then injected on the constructor below (movieService)
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
        // this.movieService = new MovieService(); // Use dependency injection to avoid this
    }

    // RESTful GET endpoint that returns a JSON. HTTP method/verb GET to get information. Example: http://localhost:8080/api/movie
	@GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    // RESTful POST endpoint. API that will take a payload and store it on our system. HTTP method/verb POST used to add new resources to your system (in this case, add a new movie)
    /* 
     * Example: {
     *              "title": "The Dark Knight",
     *              "synopsis": "I'm Batman.",
     *              "releaseDate": "2008-07-14"
     *          }
     */
    @PostMapping
    public void registerNewMovie(@RequestBody Movie movie) { // This annotation because we want to take to movie that comes from the client. We want to map the JSON into this movie by taking it from the request body, i.e., we take the request body and then map it into a movie 
        movieService.addNewMovie(movie);
    }

    // RESTful PUT endpoint to update a movie title by passing its ID and new title. Example http://localhost:8080/api/movie/1?title=newTitle
    @PutMapping(path = "{movieId}")
    public void updateMovie(@PathVariable("movieId") Long id, @RequestParam(required = false) String title) {
        movieService.updateMovie(id, title);
    }

    // RESTful DELETE endpoint to delete movie by ID. Example: http://localhost:8080/api/movie/1
    @DeleteMapping(path = "{movieId}")
    public void deleteMovieById(@PathVariable("movieId") Long id) {
        movieService.removeMovieById(id);
    }
}
