package com.jvnobrega.movie.converter.request;

import com.jvnobrega.movie.model.Actor;
import com.jvnobrega.movie.model.MovieGenre;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class MovieRequest {

    @NotBlank
    private String title;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private MovieGenre genre;

    @NotBlank
    private String storyLine;

}
