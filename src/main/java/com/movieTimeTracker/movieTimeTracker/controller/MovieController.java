package com.movieTimeTracker.movieTimeTracker.controller;

import com.movieTimeTracker.movieTimeTracker.entities.MovieRecord;
import com.movieTimeTracker.movieTimeTracker.repository.MovieRepository;
import com.movieTimeTracker.movieTimeTracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;

    //get all movie records
    @GetMapping("/movie-record")
    public List<MovieRecord> getAllMovieRecord(){
        return this.movieService.getAllMovieRecord();
    }

    //get movie-record by year
//    @GetMapping("/movie-record-by-year/{year}")
//    public List<MovieRecord> getMovieRecordByYear(@PathVariable int year){
//        return this.movieService.getMovieRecordByYear();
//    }

    //to add a movie record
    @PostMapping("/add-movie")
    public MovieRecord addMovieRecord(@RequestBody MovieRecord movieRecord){
        movieRepository.save(movieRecord);
        return movieRecord;
    }
}
