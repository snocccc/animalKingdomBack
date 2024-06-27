package com.pinoypliks.co.animalkingdom.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class User {

    User(){}

    private @Id
    @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String Gender;
    private int Age;

    public User(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        lastName = lastName;
        Gender= gender;
        Age = age;
    }

     //Setter
     public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }
    
    public void setAge(int age) {
        Age = age;
    }

    
   
    //Getter
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return Gender;
    }

    public int getAge() {
        return Age;
    }


}
