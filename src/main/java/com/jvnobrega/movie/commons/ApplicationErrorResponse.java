package com.jvnobrega.movie.commons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationErrorResponse {

  private String timestamp;

  private String error;

  private int status;

  private String message;

  private String path;

  @JsonInclude(NON_NULL)
  private List<String> details;

  @JsonIgnore
  private ApplicationErrorCode applicationErrorCode;

}
