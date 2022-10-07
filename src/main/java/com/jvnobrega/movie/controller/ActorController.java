package com.jvnobrega.movie.controller;

import com.jvnobrega.movie.commons.ResponseList;
import com.jvnobrega.movie.converter.request.ActorRequest;
import com.jvnobrega.movie.converter.request.MovieRequest;
import com.jvnobrega.movie.converter.response.ActorResponse;
import com.jvnobrega.movie.converter.response.MovieResponse;
import com.jvnobrega.movie.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/actors")
public class ActorController {

    private final ActorService actorService;

    @ResponseStatus(OK)
    @GetMapping
    public ResponseList<ActorResponse> getAll(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return actorService.getAllActors(PageRequest.of(page, pageSize, Sort.by(DESC, sortBy)));
    }

    @ResponseStatus(OK)
    @GetMapping("/{uuid}")
    public ActorResponse getActorByUuid(@PathVariable("uuid") String uuid) {
        return actorService.getByUuid(uuid);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public ActorResponse create(@RequestBody ActorRequest request) {
        return actorService.save(request);
    }
}
