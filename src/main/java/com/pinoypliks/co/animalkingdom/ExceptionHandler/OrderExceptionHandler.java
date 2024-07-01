package com.pinoypliks.co.animalkingdom.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pinoypliks.co.animalkingdom.NotFoundException.OrderNotfoundException;


@RestControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(OrderNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderNotFoundHandler(OrderNotfoundException e){
        return e.getMessage();
    }

}
