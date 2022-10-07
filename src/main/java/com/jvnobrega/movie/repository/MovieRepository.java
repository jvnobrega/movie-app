package com.jvnobrega.movie.repository;

import com.jvnobrega.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Page<Movie> findAll(Pageable pageable);

    Optional<Movie> findByUuid(String uuid);
}
