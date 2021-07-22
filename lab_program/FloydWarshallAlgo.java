package com.lab_program;

import java.util.Scanner;

class FloydWarshall{

    int vertex;
    int[][] Matrix;
    int[][] MinimumCostMatrix;

    public FloydWarshall(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of vertex : ");
        vertex = input.nextInt();

        Matrix = new int[vertex][vertex];
        MinimumCostMatrix = new int[vertex][vertex];
    }

    public void read(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the cost adjacency matrix : ");
        for( int i = 0; i < vertex; i++ )
            for( int j = 0; j < vertex; j++ )
                Matrix[i][j] = input.nextInt();
    }

    public void function(){
        for( int i = 0; i < vertex; i++ ){
            for( int j = 0; j < vertex; j++ ){
                MinimumCostMatrix[i][j] = Matrix[i][j];
            }
        }

        for(int k = 0; k < vertex; k++)
            for(int i = 0; i < vertex; i++)
                for(int j = 0; j < vertex;j++)
                    MinimumCostMatrix[i][j]=Math.min(MinimumCostMatrix[i][j], MinimumCostMatrix[i][k]+MinimumCostMatrix[k][j]);
    }

    public void display(){
        System.out.println("Shortest path matrix : ");
        for( int i = 0; i < vertex; i++ ) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(MinimumCostMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class FloydWarshallAlgo {

    public void FloydAlgoMain(){
        FloydWarshall floydWarshall = new FloydWarshall();

        floydWarshall.read();
        floydWarshall.function();
        floydWarshall.display();

    }
}
/*
0 9999 3 9999
2 0 9999 9999
9999 7 0 1
6 9999 9999 0
*/