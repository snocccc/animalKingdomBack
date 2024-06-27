package com.pinoypliks.co.animalkingdom.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Animals {

    Animals(){}

    private @Id
    @GeneratedValue Long id;
    private String animalName;
    private String Description;
    private int Quantity;

    
    public Animals(String animalName, String description, int quantity) {
        this.animalName = animalName;
        Description = description;
        Quantity = quantity;
    }

    //Setter
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Long getId() {
        return id;
    }

   
    //Getter
    public String getAnimalName() {
        return animalName;
    }

    public String getDescription() {
        return Description;
    }

    public int getQuantity() {
        return Quantity;
    }
    
}
