package com.jvnobrega.movie.converter.response;

import com.jvnobrega.movie.model.MovieGenre;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class MovieResponse implements Serializable {
    private String uuid;
    private String title;
    private LocalDate releaseDate;
    private MovieGenre genre;
    private String storyLine;
    private LocalDateTime inputDate;
    private LocalDateTime lastUpdatedDate;
    private List<String> actors;
}
