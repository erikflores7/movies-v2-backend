package me.erikflores.movies.model;

/**
 * Object for POST to get a movie
 */
public class GetMovieRequest {

    private String id;

    public GetMovieRequest(){}

    public GetMovieRequest(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

}
