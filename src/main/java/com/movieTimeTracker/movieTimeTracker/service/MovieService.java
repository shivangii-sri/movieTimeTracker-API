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

    public List<MovieRecord>getMovieRecordByYear(int year){
        return this.movieRepository.findAllByYear(year);
    }

    public MovieRecord updateMovieRecord(MovieRecord movieRecord){
        MovieRecord curObj = movieRepository.getReferenceById(movieRecord.getId());
        curObj.setMovieName(movieRecord.getMovieName());
        curObj.setComments(movieRecord.getComments());
        curObj.setRating(movieRecord.getRating());
        curObj.setContentType(movieRecord.getContentType());
        curObj.setTimeSpentInMin(movieRecord.getTimeSpentInMin());
        curObj.setFromDate(movieRecord.getFromDate());
        curObj.setToDate(movieRecord.getToDate());

        movieRepository.save(curObj);
        return movieRecord;
    }

    public boolean deleteMovieRecord(long id) throws Exception{
        MovieRecord curObj = movieRepository.getReferenceById(id);
        if(curObj == null){
            throw new Exception("record not found !");
        }
        else{
            movieRepository.delete(curObj);
            return true;
        }
    }
}
