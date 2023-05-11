package com.product.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorMessage {

    private String exception;
    private String message;
    private String path;

    public ErrorMessage(Exception exception, String path) {
        this(exception.getClass().getSimpleName(), exception.getMessage(), path);
    }

    public ErrorMessage(Throwable error, String path) {
        this(error.getClass().getSimpleName(), error.getMessage(), path);
    }

}
