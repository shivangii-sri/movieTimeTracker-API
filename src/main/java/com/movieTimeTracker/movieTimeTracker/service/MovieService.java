package com.movieTimeTracker.movieTimeTracker.service;

import com.movieTimeTracker.movieTimeTracker.entities.MovieRecord;
import com.movieTimeTracker.movieTimeTracker.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieRecord> getAllMovieRecord(){
        return this.movieRepository.findAll();
    }

//    public List<MovieRecord> getMovieRecordByYear(int year){
//        return this.movieRepository.findAllByYear(year);
//    }
}
