package com.vicente.exploringspring.movie;

import java.time.LocalDate;

public class Movie {
    private Long id;
    private String title;
    private String synopsis;
    private LocalDate releaseDate;
    private Integer age;

    public Movie() {

    }

    public Movie(String title, String synopsis, LocalDate releaseDate, Integer age) {
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.age = age;
    }

    public Movie(Long id, String title, String synopsis, LocalDate releaseDate, Integer age) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.age = age;
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
        return age;
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
