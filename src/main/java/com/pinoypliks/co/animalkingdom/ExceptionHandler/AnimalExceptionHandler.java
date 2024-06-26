package com.pinoypliks.co.animalkingdom.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pinoypliks.co.animalkingdom.NotFoundException.AnimalNotFoundException;

@RestControllerAdvice
public class AnimalExceptionHandler {

    @ExceptionHandler(AnimalNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String animalNotFoundHandler(AnimalNotFoundException e){
        return e.getMessage();
    }

}
