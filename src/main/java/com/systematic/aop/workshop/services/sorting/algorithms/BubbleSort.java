package com.systematic.aop.workshop.services.sorting.algorithms;

import com.systematic.aop.workshop.services.sorting.SortingAlgorithm;

public class BubbleSort implements SortingAlgorithm {
    static void bubbleSort(int[] arr, int n) {
        if (n == 1)                     //passes are done
        {
            return;
        }

        for (int i = 0; i < n - 1; i++)       //iteration through unsorted elements
        {
            if (arr[i] > arr[i + 1])      //check if the elements are in order
            {                           //if not, swap them
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        bubbleSort(arr, n - 1);           //one pass done, proceed to the next
    }

    public void sort(int[] array) {
        bubbleSort(array, array.length);
    }
}
