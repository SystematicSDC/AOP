package com.systematic.aop.workshop.services;

import com.systematic.aop.workshop.services.sorting.SortingAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MathService {

    public int addPositives(int a, int b) {
        return a + b;
    }

    public void sort(int [] array, SortingAlgorithm algorithm){
        algorithm.sort(array);
    }

    public int[] generateRandomNumbersArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int index = 0; index < size; index++) {
            arr[index] = random.nextInt(100 + 1);
        }
        return arr;
    }

}
