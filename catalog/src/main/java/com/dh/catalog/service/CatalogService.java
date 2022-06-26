package com.dh.catalog.service;

import com.dh.catalog.model.Movie;

public interface CatalogService {

    Movie getMovie(Integer id);

    Movie adicionarFilme(Movie movie);
}
