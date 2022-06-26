package com.dh.catalog.service;

import com.dh.catalog.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "movie", url="localhost:8080/movie")
public interface MovieFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Movie findMovie(@PathVariable Integer id);

    @RequestMapping(method = RequestMethod.POST, value = "/salvar")
    Movie saveMovie(@RequestBody Movie movie);
}
