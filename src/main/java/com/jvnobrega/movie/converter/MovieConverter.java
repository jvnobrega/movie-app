package com.jvnobrega.movie.converter;

import com.jvnobrega.movie.commons.ResponseList;
import com.jvnobrega.movie.converter.request.MovieRequest;
import com.jvnobrega.movie.converter.response.MovieResponse;
import com.jvnobrega.movie.model.Actor;
import com.jvnobrega.movie.model.Movie;
import org.springframework.data.domain.Page;

import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.String.join;

public class MovieConverter {

    private MovieConverter() {
    }

    public static ResponseList<MovieResponse> convertFromModel(Page<Movie> movies) {
        return ResponseList.<MovieResponse>builder()
                .content(movies.stream()
                        .map(MovieConverter::convertFromModel)
                        .collect(Collectors.toList()))
                .numberOfElements(movies.getNumberOfElements())
                .number(movies.getNumber())
                .size(movies.getSize())
                .totalElements(movies.getTotalElements())
                .build();
    }

    public static MovieResponse convertFromModel(Movie movie) {
        return MovieResponse
                .builder()
                .uuid(movie.getUuid())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .releaseDate(movie.getReleaseDate())
                .storyLine(movie.getStoryLine())
                .actors(movie
                        .getActors()
                        .stream()
                        .map(getFullName())
                        .collect(Collectors.toList()))
                .inputDate(movie.getInputDate())
                .lastUpdatedDate(movie.getLastUpdatedDate())
                .build();
    }

    private static Function<Actor, String> getFullName() {
        return actor ->
                join(" ", actor.getFirstName(), actor.getLastName());
    }

    public static Movie convertFromRequest(MovieRequest request) {
        return Movie
                .builder()
                .title(request.getTitle())
                .genre(request.getGenre())
                .releaseDate(request.getReleaseDate())
                .storyLine(request.getStoryLine())
                .build();
    }
}
