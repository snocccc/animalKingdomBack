package com.pinoypliks.co.animalkingdom.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pinoypliks.co.animalkingdom.Model.UserModel;



@RestController

public class UserController{

    @GetMapping ("/user")
    public UserModel getUser(){

        return new UserModel(1, "PaengLabJiwel 143", "walang_titibag69@gmail.com", "123345");
    }

    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List <UserModel> users = new ArrayList<>();
        users.add (new UserModel(1, "papapdol", "papapdol123@gmail.com", "123345"));
        users.add (new UserModel(2, "papapdal", "papapdal123@gmail.com", "qwerty"));
        users.add (new UserModel(3, "papapdel", "papapdel123@gmail.com", "678991"));
        return users;
    }   

        
    @GetMapping("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){

        return new UserModel(1, "PaengLabJiwel 143", "walang_titibag69@gmail.com", "123345");
    }

    
}
