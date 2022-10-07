package com.jvnobrega.movie.controller;

import com.jvnobrega.movie.commons.ResponseList;
import com.jvnobrega.movie.converter.request.MovieRequest;
import com.jvnobrega.movie.converter.response.MovieResponse;
import com.jvnobrega.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @ResponseStatus(OK)
    @GetMapping
    public ResponseList<MovieResponse> getAll(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return movieService.getAllMovies(PageRequest.of(page, pageSize, Sort.by(DESC, sortBy)));
    }

    @ResponseStatus(OK)
    @GetMapping("/{uuid}")
    public MovieResponse getMovieByUuid(@PathVariable("uuid") String uuid) {
        return movieService.getByUuid(uuid);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public MovieResponse create(@RequestBody MovieRequest request){
        return movieService.save(request);
    }


    @ResponseStatus(OK)
    @PutMapping("/{uuid}/actors")
    public MovieResponse addActor(@PathVariable("uuid") String uuid, @RequestBody List<String> uuidList) {
        return movieService.addActors(uuid, uuidList);
    }
}
