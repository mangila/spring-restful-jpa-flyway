package com.github.mangila.springrestfuljpa.web.controller;

import com.github.mangila.springrestfuljpa.web.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDTO> noSuchElementException(NoSuchElementException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorDTO.builder().message("Not found").value(HttpStatus.NOT_FOUND.value()).build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> exception(Exception exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorDTO.builder().message(exception.getMessage()).value(HttpStatus.INTERNAL_SERVER_ERROR.value()).build());
    }

}
