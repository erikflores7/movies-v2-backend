package me.erikflores.movies.sql;

import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class SQLConnection {

    private static Connection connection;

    private static Connection getConnection(){

        if(connection == null){
            try {
                ResourceBundle reader = ResourceBundle.getBundle("DATABASE", Locale.getDefault());
                connection = DriverManager.getConnection(reader.getString("db.url"),
                        reader.getString("db.username"), reader.getString("db.password"));
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

    public static PreparedStatement prepareStatement(String query){
        try {
            Connection connection = getConnection();
            if(connection == null){
                return null;
            }
            return connection.prepareStatement(query);
        }catch(NullPointerException | SQLException e){
            return null;
        }
    }

    public static ResultSet run(PreparedStatement statement){
        try {
            return statement.executeQuery();
        }catch(NullPointerException | SQLException e){
            return null; // TODO: Throw errors
        }
    }

}
