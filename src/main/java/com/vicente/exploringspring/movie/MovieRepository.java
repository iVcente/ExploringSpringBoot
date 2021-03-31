// Data Access layer -> Anything that access the database and specifically when working with JPA. SomethingRepository is the naming convention for this class

package com.vicente.exploringspring.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // This interface is responsible for data access
public interface MovieRepository extends JpaRepository<Movie, Long>{ // We chose ID type as Long
    
}
