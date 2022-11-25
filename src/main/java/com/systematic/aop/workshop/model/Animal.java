package com.systematic.aop.workshop.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class Animal {

    private String name;
    private int weight;

    public Animal() {
    }

    public Animal(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "Animal{" +
            "name='" + name + '\'' +
            ", weight=" + weight +
            '}';
    }
}
