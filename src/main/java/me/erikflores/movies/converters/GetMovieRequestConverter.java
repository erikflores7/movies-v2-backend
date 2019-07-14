package me.erikflores.movies.converters;

import me.erikflores.movies.model.GetMovieRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetMovieRequestConverter implements Converter<String, GetMovieRequest> {

    @Override
    public GetMovieRequest convert(String from){
        String[] data = from.split(",");
        return new GetMovieRequest(data[0], data[1], Integer.parseInt(data[2]));
    }

}
