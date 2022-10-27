package com.systematic.aop.workshop.services.sorting.algorithms;

import com.systematic.aop.workshop.services.sorting.SortingAlgorithm;

public class HeapSort implements SortingAlgorithm {
    public void sort(int[] arr)
    {
        int temp;

        for (int i = arr.length / 2 - 1; i >= 0; i--)                //build the heap
        {
            heapSort(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i > 0; i--)                            //extract elements from the heap
        {
            temp = arr[0];                                                  //move current root to end (since it is the largest)
            arr[0] = arr[i];
            arr[i] = temp;
            heapSort(arr, i, 0);                                             //recall heapify to rebuild heap for the remaining elements
        }
    }

    void heapSort(int[] arr, int n, int i)
    {
        int MAX = i; // Initialize largest as root
        int left = 2 * i + 1; //index of the left child of ith node = 2*i + 1
        int right = 2 * i + 2; //index of the right child of ith node  = 2*i + 2
        int temp;

        if (left < n && arr[left] > arr[MAX])            //check if the left child of the root is larger than the root
        {
            MAX = left;
        }

        if (right < n && arr[right] > arr[MAX])            //check if the right child of the root is larger than the root
        {
            MAX = right;
        }

        if (MAX != i)
        {                                               //repeat the procedure for finding the largest element in the heap
            temp = arr[i];
            arr[i] = arr[MAX];
            arr[MAX] = temp;
            heapSort(arr, n, MAX);
        }
    }
}
