package com.pinoypliks.co.animalkingdom.NotFoundException;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long id){

        super("could not found animal with" + id);
    }

}
