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
            builder.withId(resultSet.getString("id"));
            builder.withTitle(resultSet.getString("title"));
            builder.withReleaseDate(resultSet.getDate("release_date"));
            builder.withBlueRayReleaseDate(resultSet.getDate("dvd_release"));
            //builder.withRunTime(resultSet.getInt("runtime"));
            builder.withPosterURL(resultSet.getString("poster"));
            builder.withSummary(resultSet.getString("summary"));
            movieList.add(builder.build());
        }
        return movieList;
    }

}
