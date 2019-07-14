package me.erikflores.movies.controllers;

import me.erikflores.movies.model.GetMovieRequest;
import me.erikflores.movies.model.GetMovieResult;
import me.erikflores.movies.model.GetMovieResult.GetMovieResultBuilder;
import me.erikflores.movies.movie.Movie;
import me.erikflores.movies.sql.SQLMovieSearch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class GetMovieRequestController{

    @PostMapping("/api/GetMovieRequest")
    public GetMovieResult getMovie(@RequestBody GetMovieRequest movieRequest) throws SQLException{

        List<Movie> movieList = SQLMovieSearch.searchMovie(movieRequest);
        GetMovieResultBuilder builder = GetMovieResult.builder();
        if(movieList == null || movieList.isEmpty()){ // TODO: Throw error if null ?
            return builder.build();
        }
        for(Movie movie : movieList){
            builder.withMovie(movie);
        }
        return GetMovieResult.builder().build();

        /*return new GetMovieResult.builder().withMovie(new Movie.builder().withTitle("Testing").build())
                .withMovie(new Movie.builder().withTitle("Testing2").build()).build();*/
    }

}
