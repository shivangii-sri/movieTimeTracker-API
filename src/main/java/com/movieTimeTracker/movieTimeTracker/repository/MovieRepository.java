package com.movieTimeTracker.movieTimeTracker.repository;

import com.movieTimeTracker.movieTimeTracker.entities.MovieRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieRecord,Long> {
}
