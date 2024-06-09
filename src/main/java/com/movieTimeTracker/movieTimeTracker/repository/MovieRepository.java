package com.movieTimeTracker.movieTimeTracker.repository;

import com.movieTimeTracker.movieTimeTracker.entities.MovieRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieRecord,Long> {

    @Query("SELECT m FROM MovieRecord m WHERE YEAR(m.fromDate) = :year")
    List<MovieRecord> findAllByYear(@Param("year") int year);
}
