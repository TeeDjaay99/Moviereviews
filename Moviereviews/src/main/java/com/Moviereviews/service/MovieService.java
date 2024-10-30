package com.Moviereviews.service;


import com.Moviereviews.entity.Movie;
import com.Moviereviews.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updatedMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            movie.setDirector(movieDetails.getDirector());
            movie.setDescription(movieDetails.getDescription());
            movie.setRating(movieDetails.getRating());
        return movieRepository.save(movie);
    }
        return null;
    }


    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

}
