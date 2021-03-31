// Data Access layer -> Anything that access the database and specifically when working with JPA. SomethingRepository is the naming convention for this class

package com.vicente.exploringspring.movie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // This interface is responsible for data access
public interface MovieRepository extends JpaRepository<Movie, Long>{ // We chose ID type as Long
    
    @Query("SELECT m FROM Movie m WHERE m.title = ?1") // This is JPQL. This line is optional here, just to be more specific with like "this is the definetely query I want to execute"
    Optional<Movie> findMovieByTitle(String title); // SELECT * FROM movie WHERE title = ?
}
