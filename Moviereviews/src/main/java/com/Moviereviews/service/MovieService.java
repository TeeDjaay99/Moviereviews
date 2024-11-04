package com.Moviereviews.service;


import com.Moviereviews.entity.Movie;
import com.Moviereviews.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class MovieService {

    // Adds the repository dependency to allow access to database operations
    @Autowired
    private MovieRepository movieRepository;

    // Retrieves a list of all movies from the database
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

     // Finds a movie by it Id, if not found will not return anything
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    // Adds a movie to the database
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Updates a movie to the database with new details like change of description
    public Movie updatedMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElse(null); // Retrieves the movie by id
        // If the movie exists updates the fields with new details
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            movie.setDirector(movieDetails.getDirector());
            movie.setDescription(movieDetails.getDescription());
            movie.setRating(movieDetails.getRating());
        return movieRepository.save(movie); // If move is not found return null
    }
        return null;
    }

    // Deletes a movie from the database
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

}
