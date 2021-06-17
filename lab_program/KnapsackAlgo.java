package com.lab_program;

import java.util.Scanner;

class Knapsack{
    int size;
    int[] weight;
    int[] value;
    int maxCapacity;
    float[] solutionVector;

    Knapsack(){
        Scanner input = new Scanner( System.in );
        System.out.print("Enter the number of elements : ");
        size = input.nextInt();

        System.out.print("Enter the capacity of knapsack : ");
        maxCapacity = input.nextInt();

        weight = new int[size];
        value = new int[size];
        solutionVector = new float[size];

        for(int i = 0; i < size; i++) solutionVector[i] = 0;
    }

    void read(){
        Scanner input = new Scanner( System.in );

        System.out.print("Enter the weight of elements : ");
        for( int i = 0; i < size; i++ ){
            weight[i] = input.nextInt();
        }

        System.out.print("Enter the value of elements : ");
        for( int i = 0; i < size; i++ ){
            value[i] = input.nextInt();
        }
    }

    void operation(){

        float remainingCapacity = maxCapacity;

        for( int i = 0; i < size; i++ ) {

            if( weight[i] <= remainingCapacity ) {
                solutionVector[i]=1;
                remainingCapacity -= weight[i];
            }
            else{
                solutionVector[i] = remainingCapacity / weight[i];
                break;
            }
        }
    }

    void display(){
        float profit = 0;
        System.out.println("Solution vector is:");

        for( int i = 0; i < size; i++ ){

            profit += value[i] * solutionVector[i] ;
            System.out.print( solutionVector[i] + " " );
        }

        System.out.println("\nThe maximum profit gained : " + profit );
    }
}

public class KnapsackAlgo {

    void KnapsackMain() {
        Knapsack knapsack = new Knapsack();
        knapsack.read();
        knapsack.operation();
        knapsack.display();
    }
}