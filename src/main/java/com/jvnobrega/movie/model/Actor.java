package com.jvnobrega.movie.model;


import com.jvnobrega.movie.commons.DomainModelUuid;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@Table(name = "Actor")
public class Actor extends DomainModelUuid {

    private String firstName;

    private String lastName;

    private LocalDate birthdate;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

}
