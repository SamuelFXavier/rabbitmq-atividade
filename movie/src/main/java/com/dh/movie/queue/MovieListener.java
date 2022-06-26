package com.dh.movie.queue;

import com.dh.movie.model.Movie;
import com.dh.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieListener {

    private final MovieService movieService;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receiveMessage(Movie movie){
        movieService.adicionarFilme(movie);
    }
}
