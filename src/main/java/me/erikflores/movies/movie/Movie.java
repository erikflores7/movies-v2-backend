package me.erikflores.movies.movie;

import me.erikflores.movies.sql.SQLMovieUpdate;

import java.sql.Date;
import java.util.List;

public class Movie {

    private String id;
    private String title;
    private String oldReleaseDate;
    private Date releaseDate;
    //private List<Genre> genres;
    private Rating rating;
    private String oldPostReleaseDate;
    private Date postReleaseDate;
    private int runTime;
    private String posterURL;
    private String summary;

    private Movie(String id, String title, Date releaseDate, String oldReleaseDate, Rating rating, String oldPostReleaseDate,
                  int runTime, String posterURL, String summary){
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.oldReleaseDate = oldReleaseDate;
        this.oldPostReleaseDate = oldPostReleaseDate;
        //this.genres = genre;
        this.rating = rating;
        this.runTime = runTime;
        this.posterURL = posterURL;
        this.summary = summary;

        if(this.releaseDate == null || this.oldReleaseDate.equals("")){
            SQLMovieUpdate.addUpdatedDate(this);
        }
        // TODO: Calculate upcoming/latest
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public Date getReleaseDate(){
        return this.releaseDate;
    }

    public String getOldReleaseDate(){
        return this.oldReleaseDate;
    }

    public Rating getRating(){
        return this.rating;
    }

    public String getOldPostReleaseDate(){
        return this.oldPostReleaseDate;
    }

    public int getRunTime(){
        return this.runTime;
    }

    public String getPosterURL(){
        return this.posterURL;
    }

    public String getSummary(){
        return this.summary;
    }

    public static MovieBuilder builder(){
        return new MovieBuilder();
    }

    public static class MovieBuilder{

        private String id;
        private String title;
        private String oldReleaseDate;
        private Date releaseDate;
        //private List<Genre> genres;
        private Rating rating;
        private String oldPostReleaseDate;
        private Date postReleaseDate;
        private int runTime;
        private String posterURL;
        private String summary;

        public MovieBuilder withId(String id){
            this.id = id;
            return this;
        }

        public MovieBuilder withTitle(String title){
            this.title = title;
            return this;
        }

        public MovieBuilder withReleaseDate(Date releaseDate){
            this.releaseDate = releaseDate;
            return this;
        }

        public MovieBuilder withOldReleaseDate(String oldReleaseDate){
            this.oldReleaseDate = oldReleaseDate;
            return this;
        }
        public MovieBuilder withGenres(List<Genre> genres){
            //this.genres = genres;
            return this;
        }

        public MovieBuilder withRating(Rating rating){
            this.rating = rating;
            return this;
        }

        public MovieBuilder withOldPostReleaseDate(String releaseDate){
            this.oldPostReleaseDate = releaseDate;
            return this;
        }

        public MovieBuilder withRunTime(int runTime){
            this.runTime = runTime;
            return this;
        }

        public MovieBuilder withPosterURL(String posterURL){
            this.posterURL = posterURL;
            return this;
        }

        public MovieBuilder withSummary(String summary){
            this.summary = summary;
            return this;
        }

        public Movie build(){
            return new Movie(id, title, releaseDate, oldReleaseDate, rating, oldPostReleaseDate, runTime, posterURL, summary);
        }
    }
}
