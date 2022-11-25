package com.systematic.aop.workshop.services;

import com.systematic.aop.workshop.model.Animal;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    public Animal getAnimal(){
       return new Animal("Dog", 20);
    }
}
