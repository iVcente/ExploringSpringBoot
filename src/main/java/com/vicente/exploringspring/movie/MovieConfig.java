package com.vicente.exploringspring.movie;

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

            movieRepository.saveAll(List.of(theMartian, her));
        };
    }
    
}
