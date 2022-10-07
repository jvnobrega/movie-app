package com.jvnobrega.movie.converter.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class ActorResponse implements Serializable {
    private String uuid;

    private String firstName;

    private String lastName;

    private LocalDate birthdate;

}
