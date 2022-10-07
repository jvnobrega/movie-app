package com.jvnobrega.movie.service;

import com.jvnobrega.movie.commons.ResponseList;
import com.jvnobrega.movie.commons.ServiceException;
import com.jvnobrega.movie.converter.ActorConverter;
import com.jvnobrega.movie.converter.request.ActorRequest;
import com.jvnobrega.movie.converter.response.ActorResponse;
import com.jvnobrega.movie.model.Actor;
import com.jvnobrega.movie.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.jvnobrega.movie.converter.ActorConverter.convertFromModel;
import static com.jvnobrega.movie.exception.MovieAppErrorCode.ACTOR_NOT_FOUND;

@Log4j2
@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public ResponseList<ActorResponse> getAllActors(Pageable pageRequest) {
        return convertFromModel(actorRepository
                .findAll(pageRequest));
    }

    public ActorResponse save(ActorRequest request) {
        return convertFromModel(actorRepository
                .save(ActorConverter
                        .convertActorFromRequest(request)));
    }

    public ActorResponse getByUuid(String uuid) {
        return actorRepository.findByUuid(uuid)
                .map(ActorConverter::convertFromModel)
                .orElseThrow(() -> new ServiceException(ACTOR_NOT_FOUND));
    }
}
