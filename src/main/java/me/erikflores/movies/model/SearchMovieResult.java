package me.erikflores.movies.model;

import me.erikflores.movies.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class SearchMovieResult{

    private List<Movie> movie;

    public SearchMovieResult(){}

    private SearchMovieResult(List<Movie> movie){
        this.movie = movie;
    }

    public List<Movie> getMovies(){
        return this.movie;
    }

    public static SearchMovieResultBuilder builder(){
        return new SearchMovieResultBuilder();
    }

    public static class SearchMovieResultBuilder{

        List<Movie> movieList = new ArrayList<>();

        public SearchMovieResultBuilder withMovies(List<Movie> movies){
            movieList = movies;
            return this;
        }

        public SearchMovieResult build(){
            return new SearchMovieResult(movieList);
        }
    }

}
