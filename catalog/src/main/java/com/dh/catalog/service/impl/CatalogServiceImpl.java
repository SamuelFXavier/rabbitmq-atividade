package com.dh.catalog.service.impl;

import com.dh.catalog.CircuitBreakerException;
import com.dh.catalog.model.Movie;
import com.dh.catalog.service.CatalogService;
import com.dh.catalog.service.MovieFeign;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private MovieFeign movieFeign;

    @Override
    @CircuitBreaker(name="movie", fallbackMethod = "getMovieFallbackValue")
    @Retry(name="movie")
    public Movie getMovie(Integer id) {
        return movieFeign.findMovie(id);
    }

    @Override
    @CircuitBreaker(name="movie", fallbackMethod = "saveMovieFallbackValue")
    @Retry(name="movie")
    public Movie adicionarFilme(Movie movie) {
        return movieFeign.saveMovie(movie);
    }

    public Movie getMovieFallbackValue(CallNotPermittedException ex) throws CircuitBreakerException {
        throw new CircuitBreakerException("Circuit breaker was activated");
    }

    public Movie saveMovieFallbackValue(CallNotPermittedException ex) throws CircuitBreakerException {
        throw new CircuitBreakerException("Circuit breaker was activated");
    }
}
