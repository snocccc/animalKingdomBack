package com.pinoypliks.co.animalkingdom.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinoypliks.co.animalkingdom.Model.Animals;
import com.pinoypliks.co.animalkingdom.NotFoundException.AnimalNotFoundException;
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
    @GetMapping("/animal/{id}")
    public Animals getAnimal(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new AnimalNotFoundException(id));
      
    }
 

    @PostMapping("/Animals/new")
    public String addAnimal(@RequestBody Animals newAnimals){
        repo.save(newAnimals);
        return "A new Animals is addded, Yehey!!!";
    }


    @PutMapping("/animals/edit/{id}")
    public Animals updateAnimal(@PathVariable Long id, @RequestBody Animals newAnimals){
        return repo.findById(id)
        .map(animals ->{
            animals.setAnimalName(newAnimals.getAnimalName());
            animals.setDescription(newAnimals.getDescription());
            animals.setQuantity(newAnimals.getQuantity());
            return repo.save(animals);
        }).orElseGet(()->{
            return repo.save(newAnimals);
        });
    }


    @DeleteMapping("/animals/delete/{id}") 
    public String deleteAnimal(@PathVariable Long id){
        repo.deleteById(id);
        return "A Animal is Dead";
    }
}