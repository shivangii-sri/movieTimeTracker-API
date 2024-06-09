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

    //get all movies by year
    @GetMapping("/movie-by-year/{year}")
    public List<MovieRecord>getMovieRecordByYear(@PathVariable int year){
        return this.movieService.getMovieRecordByYear(year);
    }

    //to add a movie record
    @PostMapping("/add-movie")
    public MovieRecord addMovieRecord(@RequestBody MovieRecord movieRecord){
        movieRepository.save(movieRecord);
        return movieRecord;
    }

    //update movie record
    @PutMapping("/update-movie")
    public MovieRecord updateMovieRecord(@RequestBody MovieRecord movieRecord){
        return this.movieService.updateMovieRecord(movieRecord);
    }

    //delete movie record
    @DeleteMapping("/delete-movie/{id}")
    public boolean deleteMovieRecord(@PathVariable long id) throws Exception {
        return this.movieService.deleteMovieRecord(id);
    }
}
