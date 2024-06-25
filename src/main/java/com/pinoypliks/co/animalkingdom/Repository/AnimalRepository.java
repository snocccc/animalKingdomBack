package com.pinoypliks.co.animalkingdom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinoypliks.co.animalkingdom.Model.Animals;

public interface AnimalRepository extends JpaRepository<Animals, Long>{

}
