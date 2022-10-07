package com.jvnobrega.movie.exception;

import com.jvnobrega.movie.commons.ApplicationErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum MovieAppErrorCode implements ApplicationErrorCode {

    MOVIE_NOT_FOUND("001", NOT_FOUND, "Movie not found"),
    ACTOR_NOT_FOUND("002", NOT_FOUND, "Actor not found");


    @Getter
    private final String code;

    @Getter
    private final String message;

    @Getter
    private final HttpStatus status;

    MovieAppErrorCode(String code, HttpStatus status, String message) {
        this.code = getPrefixCode().concat(code);
        this.status = status;
        this.message = message;
    }

    @Override
    public String getPrefixCode() {
        return "MAEC-";
    }
}
