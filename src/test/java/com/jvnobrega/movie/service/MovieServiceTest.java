package com.jvnobrega.movie.service;

import com.jvnobrega.movie.commons.ResponseList;
import com.jvnobrega.movie.converter.response.MovieResponse;
import com.jvnobrega.movie.model.Movie;
import com.jvnobrega.movie.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    private static final Movie JURASSIC_PARK_MOVIE = Movie.builder()
            .title("Jurassic Park")
            .build();
    private static final Movie PUP_FICTION_MOVIE = Movie.builder()
            .title("Pulp Fiction")
            .build();
    @InjectMocks
    private MovieService service;

    @Mock
    private MovieRepository movieRepository;

    @Test
    public void getAllMovies() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Movie> movies = new PageImpl<>(List.of(PUP_FICTION_MOVIE, JURASSIC_PARK_MOVIE));

        when(movieRepository.findAll(pageRequest)).thenReturn(movies);

        ResponseList<MovieResponse> movieResponseList = service.getAllMovies(pageRequest);

        assertEquals(2, movieResponseList.getNumberOfElements());
        assertEquals("Pulp Fiction", movieResponseList.getContent().get(0).getTitle());
        assertEquals("Jurassic Park", movieResponseList.getContent().get(1).getTitle());

        verify(movieRepository).findAll(pageRequest);
    }


}