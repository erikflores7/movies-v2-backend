package me.erikflores.movies;

import me.erikflores.movies.converters.GenreConverter;
import me.erikflores.movies.converters.GetMovieRequestConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new GetMovieRequestConverter());
        registry.addConverter(new GenreConverter());
    }

}
