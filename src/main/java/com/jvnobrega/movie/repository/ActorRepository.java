package com.jvnobrega.movie.repository;

import com.jvnobrega.movie.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    Page<Actor> findAll(Pageable pageable);

    Optional<Actor> findByUuid(String uuid);
}
