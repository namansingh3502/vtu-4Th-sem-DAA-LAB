package com.lab_program;

import java.util.Scanner;
import java.util.Random;

class MergeSort{
    int[] array;
    public int size;

     MergeSort() {
        Scanner input = new Scanner( System.in );
        System.out.print("Enter the number of elements : ");

        this.size = input.nextInt();
        this.array = new int[size];
    }

    void read(){
         //Scanner input = new Scanner( System.in );
        Random rand =  new Random();
        System.out.print("Enter the elements : ");
        for( int i = 0; i < size; i++ )
            array[i] = rand.nextInt(1000);

    }

    void divide(int left, int right){
        if( left >= right ) return;

        int mid = (left + right)/ 2;

        divide( left, mid );
        divide( mid+1, right );

        merge( left, mid, right );
    }

    void merge(int left, int mid, int right ){

        int[] sorted_array = new int[size];

        int i, j, k;
        i = left;
        j = mid+1;
        k = left;

        while( i <= mid && j <= right ){
            if( array[i] < array[j] ){
                sorted_array[k] = array[i];
                i++; k++;
            }
            else{
                sorted_array[k] = array[j];
                j++; k++;
            }
        }
        while( i <= mid ){
            sorted_array[k] = array[i];
            k++; i++;
        }
        while( j <= right){
            sorted_array[k] = array[j];
            k++; j++;
        }

        for( i = left; i <= right; i++ ){
                array[i] = sorted_array[i];
        }

    }

    void display(){
        System.out.println("Elements in the array are : ");
        for( int i = 0; i < size; i++ )
            System.out.println(array[i] + " ");
    }
}

public class MergeSortAlgo {
    public static void main(String[] args ){

        MergeSort mergeSort = new MergeSort();
        mergeSort.read();

        long start = System.currentTimeMillis();

        mergeSort.divide(0, mergeSort.size-1 );

        long end = System.currentTimeMillis();

        mergeSort.display();

        System.out.println("Time taken : " + (end - start) + "  MilliSec");

    }
}