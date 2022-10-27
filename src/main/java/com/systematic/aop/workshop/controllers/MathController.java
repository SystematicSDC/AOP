package com.systematic.aop.workshop.controllers;

import com.systematic.aop.workshop.services.MathService;
import com.systematic.aop.workshop.services.sorting.algorithms.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class MathController {
    MathService mathService;

    public MathController(MathService mathService){
        this.mathService = mathService;
    }

    @PostConstruct
    public void init(){
        int a = 3;
        int b = 5;
        int result = mathService.addPositives(a, b);
        System.out.printf("%d + %d = %d %n", a, b, result);



        //even if the method does not throw exception, an exception can be thrown from the aspect.
        //see @ValidatorService which enforces parameters to be positive.
        try {
            b = -3;
            result = mathService.addPositives(a, b);
            System.out.printf("%d + %d = %d %n", a, b, result);
        } catch (Exception e) {
            System.out.printf("%d + %d = error (%s) %n", a, b, e.getCause().getMessage());
        }



        //create array with random numbers
        int[] array = mathService.generateRandomNumbersArray(100);

        System.out.print("Sorting array: ");
        Arrays.stream(array).forEach(i -> System.out.printf("%d ", i));
        System.out.printf("%n");

        //sort with different algorithms
        mathService.sort(array.clone(), new BubbleSort());
        mathService.sort(array.clone(), new HeapSort());
        mathService.sort(array.clone(), new InsertionSort());
        mathService.sort(array.clone(), new MergeSort());
        mathService.sort(array.clone(), new SelectionSort());
    }
}
