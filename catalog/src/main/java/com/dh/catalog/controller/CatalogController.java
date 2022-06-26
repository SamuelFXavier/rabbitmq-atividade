package com.dh.catalog.controller;

import com.dh.catalog.model.Movie;
import com.dh.catalog.service.CatalogService;
import com.dh.catalog.service.MovieFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    private final MovieFeign movieFeign;

    private final RabbitTemplate rabbitTemplate;

//    @PostMapping
//    public ResponseEntity<MovieDTO> adicionarFilme(MovieDTO movieDTO){
//        return ResponseEntity.status(HttpStatus.CREATED).body(catalogService.adicionarFilme(movieDTO));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> recuperarFilme(@PathVariable Integer id){
        return ResponseEntity.ok(catalogService.getMovie(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> adicionarFilme(@RequestBody Movie movie) {
        rabbitTemplate.convertAndSend("MovieQueue", movie);
        return ResponseEntity.status(HttpStatus.CREATED).body("Filme cadastrado com sucesso!");
    }
}
