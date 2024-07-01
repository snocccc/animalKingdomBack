package com.pinoypliks.co.animalkingdom.NotFoundException;


public class OrderNotfoundException extends RuntimeException{
    public OrderNotfoundException(Long id){
        super("Could Not Found Order with: " + id);
    }

}
