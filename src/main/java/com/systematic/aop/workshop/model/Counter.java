package com.systematic.aop.workshop.model;

import org.springframework.stereotype.Component;

@Component
public class Counter {

    private int counter = 0;
    private static Counter INSTANCE;

    private Counter() {
    }

    public static Counter getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Counter();
        }
        return INSTANCE;
    }

    public static void addToCounter(){
        INSTANCE.counter++;
    }

    public static void resetCounter(){
        INSTANCE.counter = 0;
    }

    public int getCounter() {
        return counter;
    }
}

