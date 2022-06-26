package com.dh.movie.service;

import com.dh.movie.model.Movie;
import com.dh.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie adicionarFilme(Movie movie){
        return movieRepository.save(movie);
    }

    public Optional<Movie> recuperarFilme(Integer id){
        return movieRepository.findById(id);
    }
}
