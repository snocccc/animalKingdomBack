package com.pinoypliks.co.animalkingdom.NotFoundException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){

        super("could not found User with" + id);
    }

}