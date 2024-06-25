package com.pinoypliks.co.animalkingdom.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinoypliks.co.animalkingdom.Model.Animals;
import com.pinoypliks.co.animalkingdom.Repository.AnimalRepository;


@RestController
public class AnimalController {

    AnimalRepository repo;
   
    public AnimalController(AnimalRepository repo) {
        this.repo = repo;
    }


    @GetMapping("/Animals")
    public List<Animals>getAnimals(){
        return repo.findAll();
    }

 /*    public Animals getAnimal(Long id){
        return repo.findById(id);
    }
 */

    @PostMapping("/Animals/new")
    public String addAnimal(@RequestBody Animals newAnimals){
        repo.save(newAnimals);
        return "A new Animals is addded, Yehey!!!";
    }
}
