package me.erikflores.movies.sql;

import me.erikflores.movies.movie.Movie;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SQLMovieUpdate {

    public static void addMovie(Movie movie){

    }

    // TODO: Need to convert all current movies
    public static void addUpdatedDate(Movie movie){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy");
        try {
            Date newDate = new Date(dateFormatter.parse(movie.getOldReleaseDate()).getTime());
            PreparedStatement statement = SQLConnection.prepareStatement("UPDATE movies SET releaseDate = ? WHERE id = ?;");
            statement.setDate(1, newDate);
            statement.setString(2, movie.getId());
            statement.execute();
            statement = SQLConnection.prepareStatement("UPDATE movies SET release_date = '' WHERE id = ?;");
            statement.setString(1, movie.getId());
            statement.execute();
            System.out.println("Successfully updated Release Date for movie: " + movie.getTitle());
        } catch (SQLException | NullPointerException | ParseException e) {
            System.out.println("Couldn't update Release Date for movie: " + movie.getTitle());
            System.out.println(e.getMessage());
        }
    }

}
