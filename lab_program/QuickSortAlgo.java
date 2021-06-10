package com.lab_program;

import java.util.Random;
import java.util.Scanner;

class QuickSort {
    int[] array;
    public int size;

    QuickSort() {
        Scanner input = new Scanner( System.in );
        System.out.print("Enter the number of elements : ");

        this.size = input.nextInt();
        this.array = new int[size];
    }
    void read(){
        //Scanner input = new Scanner( System.in );
        Random rand =  new Random();
        //System.out.print("Enter the elements : ");
        for( int i = 0; i < size; i++ )
            array[i] = rand.nextInt(1000);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {

            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    void display(){
        System.out.println("Elements in the array are : ");
        for( int i = 0; i < size; i++ )
            System.out.println(array[i] + " ");
    }
}

public class QuickSortAlgo {
    void QuickSortMain(){

        QuickSort quickSort = new QuickSort();
        quickSort.read();

        long start = System.currentTimeMillis();

        quickSort.quicksort(quickSort.array, 0, quickSort.size - 1);

        long end = System.currentTimeMillis();

        quickSort.display();

        System.out.println("Time taken : " + (end - start) + "  MilliSec");

    }
}