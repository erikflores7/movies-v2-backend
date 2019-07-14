package me.erikflores.movies.model;

/**
 * Object for POST to search for a movie
 */
public class GetMovieRequest {

    private String id;
    private String title;
    private int year;
    //private Genre genre

    public GetMovieRequest(){}

    public GetMovieRequest(String id, String title, int year){
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public int getYear(){
        return this.year;
    }

}
