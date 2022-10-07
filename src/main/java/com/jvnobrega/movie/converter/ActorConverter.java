package com.jvnobrega.movie.converter;

import com.jvnobrega.movie.commons.ResponseList;
import com.jvnobrega.movie.converter.request.ActorRequest;
import com.jvnobrega.movie.converter.response.ActorResponse;
import com.jvnobrega.movie.converter.response.MovieResponse;
import com.jvnobrega.movie.model.Actor;
import com.jvnobrega.movie.model.Movie;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

public class ActorConverter {

    private ActorConverter() {
    }

    public static ResponseList<ActorResponse> convertFromModel(Page<Actor> actors) {
        return ResponseList.<ActorResponse>builder()
                .content(actors.stream()
                        .map(ActorConverter::convertFromModel)
                        .collect(Collectors.toList()))
                .numberOfElements(actors.getNumberOfElements())
                .number(actors.getNumber())
                .size(actors.getSize())
                .totalElements(actors.getTotalElements())
                .build();
    }

    public static Actor convertActorFromRequest(ActorRequest request) {
        return Actor
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthdate(request.getBirthdate())
                .build();
    }

    public static ActorResponse convertFromModel(Actor actor) {
        return ActorResponse.builder()
                .uuid(actor.getUuid())
                .birthdate(actor.getBirthdate())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .build();
    }


}
