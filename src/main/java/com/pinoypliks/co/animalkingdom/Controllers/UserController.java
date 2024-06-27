package com.pinoypliks.co.animalkingdom.Controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinoypliks.co.animalkingdom.Model.User;
import com.pinoypliks.co.animalkingdom.NotFoundException.UserNotFoundException;
import com.pinoypliks.co.animalkingdom.Repository.UserRepository;





@RestController

public class UserController{

    UserRepository repo;
    
    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @GetMapping("/User")
    public List<User>getUser(){
        return repo.findAll();
    }
    
    
    @GetMapping("/User/{id}")
    public User getUser(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new UserNotFoundException(id));
      
    }

    @PostMapping("/User/new")
    public String addUser(@RequestBody User newUser){
        repo.save(newUser);
        return "A new User is Added, KABOOM!!!";
    }

     @PutMapping("/User/edit/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser){
        return repo.findById(id)
        .map(User ->{
            User.setFirstName(newUser.getFirstName());
            User.setLastName(newUser.getLastName());
            User.setGender(newUser.getGender());
            User.setAge(newUser.getAge());
            return repo.save(User);
        }).orElseGet(()-> {
            return repo.save(newUser);
        });    
       
    }
    
     @DeleteMapping("/User/delete/{id}") 
    public String deleteUser(@PathVariable Long id){
        repo.deleteById(id);
        return "The User Was Remove";
    }
}
