package me.erikflores.movies.sql;

import java.sql.*;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class SQLConnection {

    private static Connection connection;

    private static Date openedAt; // TODO: Set up pooling instead of using this method
    private static final int MAX_TIME_OPEN = 5 * 60 * 1000;

    private static Connection getConnection() throws SQLException {

        if(connection == null){
            ResourceBundle reader = ResourceBundle.getBundle("DATABASE", Locale.getDefault());
            connection = DriverManager.getConnection(reader.getString("db.url"),
                        reader.getString("db.username"), reader.getString("db.password"));
            openedAt = Date.valueOf(LocalDate.now());
        }else if(Date.valueOf(LocalDate.now()).getTime() - openedAt.getTime() >= MAX_TIME_OPEN){
            connection.close();
            connection = null;
            connection = getConnection();
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
