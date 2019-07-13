package me.erikflores.movies.movie;

import java.sql.Date;
import java.util.List;

public class Movie {

    private String id;
    private String title;
    private Date releaseDate;
    private List<Genre> genres;
    private Rating rating;
    private Date blurayReleaseDate;
    private int runTime;
    private String posterURL;
    private boolean isUpcoming;
    private boolean isLatest;
    private String summary;

    private Movie(String id, String title, Date releaseDate, List<Genre> genre, Rating rating, Date blurayReleaseDate,
                  int runTime, String posterURL, String summary){
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genres = genre;
        this.rating = rating;
        this.blurayReleaseDate = blurayReleaseDate;
        this.runTime = runTime;
        this.posterURL = posterURL;
        this.summary = summary;
        // TODO: Calculate upcoming/latest
    }

    public static class builder{

        private String id;
        private String title;
        private Date releaseDate;
        private List<Genre> genres;
        private Rating rating;
        private Date blurayReleaseDate;
        private int runTime;
        private String posterURL;
        private String summary;

        public builder withId(String id){
            this.id = id;
            return this;
        }

        public builder withTitle(String title){
            this.title = title;
            return this;
        }

        public builder withReleaseDate(Date releaseDate){
            this.releaseDate = releaseDate;
            return this;
        }

        public builder withGenres(List<Genre> genres){
            this.genres = genres;
            return this;
        }

        public builder withRating(Rating rating){
            this.rating = rating;
            return this;
        }

        public builder withBlueRayReleaseDate(Date releaseDate){
            this.blurayReleaseDate = releaseDate;
            return this;
        }

        public builder withRunTime(int runTime){
            this.runTime = runTime;
            return this;
        }

        public builder withPosterURL(String posterURL){
            this.posterURL = posterURL;
            return this;
        }

        public builder withSummary(String summary){
            this.summary = summary;
            return this;
        }

        public Movie build(){
            return new Movie(id, title, releaseDate, genres, rating, blurayReleaseDate, runTime, posterURL, summary);
        }
    }
}
