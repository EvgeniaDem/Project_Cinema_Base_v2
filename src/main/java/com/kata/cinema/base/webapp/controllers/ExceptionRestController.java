package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class ExceptionRestController {

    //public static final Logger LOGGER = LoggerFactory.getLogger(ExceptionRestController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalException(Exception exception) {
       /* String msg = StackWalker
                .getInstance()
                .walk(s -> s.map(stackFrame -> stackFrame.getClassName() + " / " + stackFrame.getMethodName()).limit(10).toString());
        LOGGER.error(msg, exception, exception.getCause());*/
        log.error("Internal server error", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), new Date(), HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundByIdException.class)
    public ResponseEntity<ErrorResponse> notFoundByIdException(NotFoundByIdException idException) {
        ErrorResponse errorResponse = new ErrorResponse(idException.getMessage(), new Date(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
