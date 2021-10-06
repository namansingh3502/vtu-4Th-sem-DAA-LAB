package com.lab_program;

import java.util.Scanner;

class DynamicKnapsack {
    int objectCount;
    int capacity;
    int[] profit;
    int[] weight;
    int[][] v;
    public DynamicKnapsack() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of objects");
        this.objectCount = input.nextInt();

        System.out.println("Enter capacity of Knapsack");
        this.capacity = input.nextInt();

        this.profit =  new int[objectCount+1];
        this.weight = new int[objectCount+1];
        this.v = new int[objectCount + 1][capacity + 1];
    }

    void read(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter profit for each " + objectCount + " objects");
        for( int i = 1; i <= objectCount; i++ )
            profit[i] = input.nextInt();
        System.out.println("Enter weight for each " + objectCount + " objects");
        for( int i = 1; i <= objectCount; i++ )
            weight[i] = input.nextInt();
    }
    void operation() {
        for (int i = 0; i <= objectCount; ++ i) {
            for (int j = 0; j <= capacity; ++ j) {
                if ( i == 0 || j == 0 ) {
                    v[i][j] = 0;
                }
                else if ( j - weight[i] >= 0 ) {
                    v[i][j] = Math.max ( v[i - 1][j], profit[i] + v[i - 1][j - weight[i]]);
                }
                else if ( j - weight[i] < 0 ) {
                    v[i][j] = v[i - 1][j];
                }
            }
        }
        System.out.println("Optimal Solution: " + v[objectCount][capacity]);
    }
    void display() {
        System.out.println("The objects picked up into knapsack are:");
        int i = objectCount+1;
        int j = capacity;
        while( --i > 0 ){
            if(v[i][j] != v[i-1][j]){
                System.out.print(i + " ");
                j = j - weight[i];
            }
        }
    }
}
public class DynamicKnapsackAlgo {
    public static void main(String[] args ) {
        DynamicKnapsack dk = new DynamicKnapsack();
        dk.read();
        dk.operation();
        dk.display();
    }
}

/*
5

20

3
4
5
8
10

2
3
4
5
9
*/
