package com.pinoypliks.co.animalkingdom.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.pinoypliks.co.animalkingdom.Model.UserModel;

@RestController

public class UserController{

    @GetMapping ("/User")
    public UserModel getUser(){

        return new UserModel(1, "PaengLabJiwel 143", "walang_titibag69@gmail.com", "123345");
    }
}
