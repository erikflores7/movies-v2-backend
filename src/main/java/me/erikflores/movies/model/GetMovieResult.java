package me.erikflores.movies.model;

import me.erikflores.movies.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class GetMovieResult {

    private List<Movie> movie;

    public GetMovieResult(){}

    private GetMovieResult(List<Movie> movie){
        this.movie = movie;
    }

    public List<Movie> getMovies(){
        return this.movie;
    }

    public static GetMovieResultBuilder builder(){
        return new GetMovieResultBuilder();
    }

    public static class GetMovieResultBuilder{

        List<Movie> movieList = new ArrayList<>();

        public GetMovieResultBuilder withMovie(Movie movie){
            movieList.add(movie);
            return this;
        }

        public GetMovieResult build(){
            return new GetMovieResult(movieList);
        }
    }

}
