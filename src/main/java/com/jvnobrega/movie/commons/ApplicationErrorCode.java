package com.jvnobrega.movie.commons;

import org.springframework.http.HttpStatus;

public interface ApplicationErrorCode {

  String getPrefixCode();

  String getCode();

  String getMessage();

  HttpStatus getStatus();
}
