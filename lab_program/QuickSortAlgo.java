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
    int partition( int low, int high) {

        int pivot = array[low];
        int i = low+1;
        int j = high+1;

        while( i < j ){
            do i++;
            while ( pivot >= array[i] );

            do j--;
            while( pivot < array[j] );

            if( i < j ){
                swap( array, i, j);
            }
        }

        swap(array, low, j);
        return j;
    }

    void quicksort( int low, int high) {
        if (low < high) {
            int pi = partition( low, high);

            quicksort( low, pi - 1);
            quicksort(pi + 1, high);
        }
    }

    void display(){
        System.out.println("Elements in the array are : ");
        for( int i = 0; i < size; i++ )
            System.out.println(array[i] + " ");
    }
}

public class QuickSortAlgo {
    public static void main(String[] args ){

        QuickSort quickSort = new QuickSort();
        quickSort.read();

        long start = System.currentTimeMillis();

        quickSort.quicksort(0, quickSort.size - 1);

        long end = System.currentTimeMillis();

        quickSort.display();

        System.out.println("Time taken : " + (end - start) + "  MilliSec");

    }
}