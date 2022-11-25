package com.systematic.aop.workshop.services.sorting.algorithms;

import com.systematic.aop.workshop.services.sorting.SortingAlgorithm;

public class SelectionSort implements SortingAlgorithm {

    public void sort(int[] arr) {
        int pos;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[pos])                  //find the index of the minimum element
                {
                    pos = j;
                }
            }

            temp = arr[pos];            //swap the current element with the minimum element
            arr[pos] = arr[i];
            arr[i] = temp;
        }
    }
}
