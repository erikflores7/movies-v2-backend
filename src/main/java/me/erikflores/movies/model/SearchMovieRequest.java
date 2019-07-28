package me.erikflores.movies.model;

public class SearchMovieRequest{

    private String path;

    public SearchMovieRequest(){}

    public SearchMovieRequest(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

}
