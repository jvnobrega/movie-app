package com.jvnobrega.movie.service;

import com.jvnobrega.movie.commons.ResponseList;
import com.jvnobrega.movie.commons.ServiceException;
import com.jvnobrega.movie.converter.MovieConverter;
import com.jvnobrega.movie.converter.request.MovieRequest;
import com.jvnobrega.movie.converter.response.MovieResponse;
import com.jvnobrega.movie.model.Actor;
import com.jvnobrega.movie.model.Movie;
import com.jvnobrega.movie.repository.ActorRepository;
import com.jvnobrega.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.jvnobrega.movie.converter.MovieConverter.convertFromModel;
import static com.jvnobrega.movie.exception.MovieAppErrorCode.ACTOR_NOT_FOUND;
import static com.jvnobrega.movie.exception.MovieAppErrorCode.MOVIE_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    private final ActorRepository actorRepository;

    public ResponseList<MovieResponse> getAllMovies(Pageable pageRequest) {
        return convertFromModel(movieRepository
                .findAll(pageRequest));
    }

    public MovieResponse save(MovieRequest request) {
        return convertFromModel(movieRepository
                .save(MovieConverter
                        .convertFromRequest(request)));
    }

    public MovieResponse getByUuid(String uuid) {
        return movieRepository.findByUuid(uuid)
                .map(MovieConverter::convertFromModel)
                .orElseThrow(() -> new ServiceException(MOVIE_NOT_FOUND));
    }

    public MovieResponse addActors(String uuid, List<String> uuidList) {
        Movie movie = movieRepository.findByUuid(uuid)
                .orElseThrow(() -> new ServiceException(MOVIE_NOT_FOUND));

        movie.getActors()
                .addAll(uuidList.stream()
                .map(getActor())
                .collect(Collectors.toList()));

        return convertFromModel(movieRepository
                .save(movie));
    }

    private Function<String, Actor> getActor() {
        return actorUuid -> actorRepository.findByUuid(actorUuid)
                .orElseThrow(() -> new ServiceException(ACTOR_NOT_FOUND));
    }


}
