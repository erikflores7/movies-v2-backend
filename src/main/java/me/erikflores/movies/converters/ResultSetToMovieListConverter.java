package me.erikflores.movies.converters;

import me.erikflores.movies.movie.Movie;
import me.erikflores.movies.movie.Movie.MovieBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetToMovieListConverter{

    public static List<Movie> convert(ResultSet resultSet) throws SQLException{
        List<Movie> movieList = new ArrayList<>();
        while(resultSet.next()){
            MovieBuilder builder = Movie.builder();
            builder.withId(resultSet.getString("id"))
                    .withTitle(resultSet.getString("title"))
                    .withReleaseDate(resultSet.getDate("releaseDate"))
                    .withOldReleaseDate(resultSet.getString("release_date"))
                    .withOldPostReleaseDate(resultSet.getString("dvd_release"))
                    /*.withRunTime(resultSet.getInt("runtime"))*/
                    .withPosterURL(resultSet.getString("poster"))
                    .withSummary(resultSet.getString("summary"));
            movieList.add(builder.build());
        }
        return movieList;
    }

}
