package me.erikflores.movies.converters;

import me.erikflores.movies.movie.Genre;
import org.springframework.core.convert.converter.Converter;

public class GenreConverter implements Converter<String, Genre> {

    @Override
    public Genre convert(String input){
        try {
           return Genre.valueOf(input.toUpperCase());
        }catch(IllegalArgumentException e){
            return null;
        }
    }

}
