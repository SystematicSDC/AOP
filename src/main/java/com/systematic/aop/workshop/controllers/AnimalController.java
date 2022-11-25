package com.systematic.aop.workshop.controllers;

import com.systematic.aop.workshop.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class AnimalController {

    AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostConstruct
    public void init() {
            System.out.println("**** This is My Animal ****");
            System.out.println(animalService.getAnimal().toString());
            System.out.println();
        }
    }
