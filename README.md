# ExploringSpringBoot

A study on Spring Boot that creates an API which provides four endpoints with each HTTP method. The API is centered around movies, you can access the movies already added to the database, modify their information or register your own. This project was made with the help of Nelson from the YouTube channel "[Amigoscode](https://www.youtube.com/c/amigoscode/videos)". The video in question is this [one](https://youtu.be/9SGDpanrc8U). Great content and tremendous help!

How to run the program
---

1. First of all, you need to have [PostgreSQL](https://www.postgresql.org/download/) installed on your machine;
2. Open PostgreSQL and start it. Create a local database called "movie" and make sure it's running. If you don't know how to do that or are facing some problems, there's this Gist to help you;
3. After downloading the project, run this command from inside its folder:
`./mvnw install`. This will create a file with `.jar` extension so you can execute the program. Remember, if the database is not set up and running correctly, this will fail;
4. Now, execute: `java -jar target/exploringspring-0.0.1-SNAPSHOT.jar`. After this, the server should be running;
5. You can access http://localhost:8080/api/movie on your browser to check all the movies stored on the database. They'll be displayed in JSON format;

> HTTP methods/verbs

The API provides four endpoints. You can use a software like [Postman](https://www.postman.com/downloads/) to send requests and view responses for each endpoint, with each making use of one HTTP method:

* **GET** for getting all the movies: http://localhost:8080/api/movie/
* **POST** for creating a movie: http://localhost:8080/api/movie and in the body of the request you could put something like this:
```java
{
    "title": "The Dark Knight",
    "synopsis": "I'm Batman.",
    "releaseDate": "2008-07-14"
}
```
* **PUT** for updating a movie information: http://localhost:8080/api/movie/1?title=Khaaaan where "1" is the movie ID
* **DELETE** for deleting a movie: http://localhost:8080/api/movie/1

Technologies, libraries and frameworks used
---

* Java
* Spring Boot
* PostgreSQL
