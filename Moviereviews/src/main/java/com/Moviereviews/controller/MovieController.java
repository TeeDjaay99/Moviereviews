package com.Moviereviews.controller;


import com.Moviereviews.entity.Movie;
import com.Moviereviews.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Get endpoint to retrieve all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Get endpoint to retrieve the specific id of a movie
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
       Movie movie = movieService.getMovieById(id); // Get movie by id by using the service
       if (movie == null) {
           return ResponseEntity.notFound().build(); // Check if the movie exists, if not will return not found
       }
       return ResponseEntity.ok(movie);
    }

    // Post endpoint to create a new movie
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        Movie updatedMovie = movieService.updatedMovie(id, movieDetails); // Calls the service to update the movie
        if (updatedMovie == null) {
            return ResponseEntity.notFound().build(); // If movie with specific id is not found will return not found
        }
        return ResponseEntity.ok(updatedMovie); // If update is successful return the updated movie
    }

    // Delete endpoint to delete a movie by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id); // Calls the service method to delete a movie
        return ResponseEntity.noContent().build(); 
    }


}
