package me.erikflores.movies.sql;

import me.erikflores.movies.converters.ResultSetToMovieListConverter;
import me.erikflores.movies.model.GetMovieRequest;
import me.erikflores.movies.movie.Movie;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SQLMovieSearch {

    public static List<Movie> searchMovie(GetMovieRequest search) throws SQLException{
        PreparedStatement statement;
        if(search.getId() != null){
             statement = SQLConnection.prepareStatement("SELECT * FROM movies WHERE lower(id) LIKE lower(?);");
             statement.setString(1, search.getId());
        }else if(search.getTitle() != null & search.getYear() != 0){
            statement = SQLConnection.prepareStatement("SELECT * FROM movies WHERE lower(title) LIKE lower(?)" +
                    " AND year= ?;");
            statement.setString(1, search.getTitle());
            statement.setInt(2, search.getYear());
        }else if(search.getTitle() != null){
            statement = SQLConnection.prepareStatement("SELECT * FROM movies WHERE lower(title) LIKE lower(?);");
            statement.setString(1, search.getTitle());
        }else if(search.getYear() != 0){
            statement = SQLConnection.prepareStatement("SELECT * FROM movies WHERE year= ?;");
            statement.setInt(1, search.getYear());
        }else{
             // TODO: Throw error, no parameters provided
            //throw new InvalidInputException();
            return null;
        }
        return ResultSetToMovieListConverter.convert(statement.executeQuery());
    }

    // TODO: AddMovie, UpdateMovie, RemoveMovie(?)

}
