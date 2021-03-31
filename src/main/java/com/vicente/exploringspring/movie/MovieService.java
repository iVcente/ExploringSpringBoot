// Service Layer -> mainly responsible for business logic

package com.vicente.exploringspring.movie;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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

	public void addNewMovie(Movie movie) {
		Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());

		if (movieOptional.isPresent())
			throw new IllegalStateException("Movie already registered!");

		movieRepository.save(movie);
	}

	public void removeMovieById(Long movieId) {
		boolean exists = movieRepository.existsById(movieId);

		if (!exists)
			throw new IllegalStateException("We didn't find any movie with this ID: " + movieId + " :(");

		movieRepository.deleteById(movieId);
	}

	@Transactional // With this annotation we don't have to use or implement any JPQL queries. We can use setters to update movie info in database
	public void updateMovie(Long id, String title) {
		Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalStateException("We didn't find any movie with this ID: " + id + " :("));

		if (title != null && title.length() > 0 && !Objects.equals(movie.getTitle(), title))
			movie.setTitle(title);
	}
}
