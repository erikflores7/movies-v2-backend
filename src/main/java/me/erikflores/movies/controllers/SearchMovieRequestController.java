package me.erikflores.movies.controllers;

import me.erikflores.movies.model.SearchMovieRequest;
import me.erikflores.movies.model.SearchMovieResult;
import me.erikflores.movies.movie.Movie;
import me.erikflores.movies.sql.SQLMovieSearch;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SearchMovieRequestController{

    @CrossOrigin(origins = "*")
    @PostMapping("/api/v1/SearchMovieRequest")
    public SearchMovieResult searchMovie(@RequestBody SearchMovieRequest movieRequest) throws SQLException{
        System.out.println("Path: " + movieRequest.getPath());
        String[] params = movieRequest.getPath().split("/");
        List<Movie> movieList = null;
        SearchMovieResult.SearchMovieResultBuilder builder = SearchMovieResult.builder();
        if(params[0].equalsIgnoreCase("movies") && params[1].equalsIgnoreCase("search")){
            switch(params[2].toLowerCase()){
                case "title":
                    movieList = SQLMovieSearch.searchMovieByTitle(params[3]);
                    break;
                case "latest":
                    break;
                case "upcoming":
                    break;
                case "year":
                    break;
                case "genre":
                    break;
            }
            // TODO: Check for sorting
            if(movieList != null){
                System.out.println("Found " + movieList.size() + " movies!");
                return builder.withMovies(movieList).build();
            }
        }
        return builder.build();
    }



}
