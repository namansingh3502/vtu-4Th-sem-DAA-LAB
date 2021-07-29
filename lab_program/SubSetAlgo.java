package com.lab_program;

import javax.swing.*;
import java.util.Scanner;

class SubSet{
    int[] set;
    int[] arr;
    int size, sum, newsum;

    SubSet() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements of set");
        size = input.nextInt();

        set = new int[size + 1];
        arr = new int[size + 1];

        System.out.println("Enter the number of elements of set");
        for (int i = 1; i <= size; i++) {
            set[i] = input.nextInt();
        }

        System.out.println("enter the positive integer sum");
        sum = input.nextInt();
    }

    void subset(int num, int[] arr){
        for( int i = 1; i <= size; i++ )
            arr[i]=0;
        for( int i = size; num != 0; i-- ){
            arr[i] = num%2;
            num = num/2;
        }
    }

    void operation() {
        int present = 0;
        if (sum > 0) {
            for (int i = 1; i <= Math.pow(2, size) - 1; i++) {
                subset(i, arr);
                newsum = 0;
                for (int j = 1; j <= size; j++) {
                    if (arr[j] == 1)
                        newsum = newsum + set[j];
                }
                if (sum == newsum) {
                    System.out.print("Subset = { ");
                    present = 1;
                    for (int j = 1; j <= size; j++) {
                        if (arr[j] == 1) {
                            System.out.print(set[j] + ",");
                        }
                    }
                    System.out.print("} = " + sum);
                    System.out.println();

                }
            }
        }
        if (present == 0)
            System.out.println("Solution does not exists");

    }
}


public class SubSetAlgo {
    public static void main(String[] args ){

        SubSet subsetAlgo = new SubSet();
        subsetAlgo.operation();
    }
}
