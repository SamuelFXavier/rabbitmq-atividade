package com.dh.movie.controller;

import com.dh.movie.model.Movie;
import com.dh.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movie")
@RefreshScope
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/salvar")
    public ResponseEntity<Object> adicionarFilme(@RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.adicionarFilme(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> recuperarFilme(@PathVariable Integer id){
        return ResponseEntity.ok(movieService.recuperarFilme(id));
    }
}
