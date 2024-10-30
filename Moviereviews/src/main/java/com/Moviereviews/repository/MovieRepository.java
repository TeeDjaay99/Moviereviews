package com.Moviereviews.repository;

import com.Moviereviews.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
//Ärver CRUD metoder från Jpa repository