package com.vicente.exploringspring.movie;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

// These annotations below have the purpose to map this movie to our database
@Entity // For hibernate
@Table // For the table in our database
public class Movie {
    // Theses annotations below have the purpose to make the database generate the movie id
    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence") // Default/Recommended por Postgres
    private Long id;
    private String title;
    private String synopsis;
    private LocalDate releaseDate;
    @Transient // Basically says: this field/attribute below has no need to be a column in our database
    private Integer age;

    public Movie() {

    }

    public Movie(String title, String synopsis, LocalDate releaseDate) {
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
    }

    public Movie(Long id, String title, String synopsis, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getAge() {
        return Period.between(releaseDate, LocalDate.now()).getYears();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Movie {" +
                "ID = " + id +
                ", title = " + title +
                ", synopsis = " + synopsis +
                ", release date = " + releaseDate +
                ", age = " + age +
                "}";
    }
}
