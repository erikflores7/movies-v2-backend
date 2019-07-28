package me.erikflores.movies.model;

import me.erikflores.movies.movie.Movie;

public class GetMovieResult {

    private Movie movie;

    public GetMovieResult(){}

    private GetMovieResult(Movie movie){
        this.movie = movie;
    }

    public Movie getMovie(){
        return this.movie;
    }

    public static GetMovieResultBuilder builder(){
        return new GetMovieResultBuilder();
    }

    public static class GetMovieResultBuilder{

        Movie movie;

        public GetMovieResultBuilder withMovie(Movie movie){
            this.movie = movie;
            return this;
        }

        public GetMovieResult build(){
            return new GetMovieResult(movie);
        }
    }

}
