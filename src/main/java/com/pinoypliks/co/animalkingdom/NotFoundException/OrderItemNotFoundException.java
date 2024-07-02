package com.pinoypliks.co.animalkingdom.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException{
    public OrderItemNotFoundException(Long id){
        super("Could Not Found Order Item with: " + id);
    }

}
