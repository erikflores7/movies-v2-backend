package me.erikflores.movies.controllers;

import me.erikflores.movies.movie.Movie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @PostMapping("/movies")
    public Movie getMovie(@RequestBody Movie movie) {
        return movie;
    }
}
