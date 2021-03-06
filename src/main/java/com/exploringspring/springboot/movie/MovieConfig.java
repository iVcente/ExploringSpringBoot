package com.exploringspring.springboot.movie;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) { // Injecting Repository
        return args -> {
            Movie theMartian = new Movie("The Martian", "An astronaut left on Mars.", LocalDate.of(2015, Month.SEPTEMBER, 11));
            Movie her = new Movie("Her", "A guy that dates his OS.", LocalDate.of(2013, Month.OCTOBER, 12));
            // Movie darkKnight = new Movie("The Dark Knight", "I'm Batman.", LocalDate.of(2008, Month.JULY, 14));

            movieRepository.saveAll(List.of(theMartian, her));
        };
    }
    
}
