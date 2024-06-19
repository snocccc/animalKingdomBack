package com.pinoypliks.co.animalkingdom.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController{

    @GetMapping ("/HelloWorld")
    public String helloWorld(){
        return "Hello World";
    }
}