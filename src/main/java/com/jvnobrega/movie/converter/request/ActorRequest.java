package com.jvnobrega.movie.converter.request;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class ActorRequest {

    private String firstName;

    private String lastName;

    private LocalDate birthdate;

}
