package com.jvnobrega.movie.model;

import com.jvnobrega.movie.commons.DomainModelUuid;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@Table(name = "movie")
public class Movie extends DomainModelUuid {

    private String title;

    private LocalDate releaseDate;

    @Enumerated(STRING)
    private MovieGenre genre;

    private String storyLine;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Actor> actors;

}
