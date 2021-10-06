package com.lab_program;

import java.util.Scanner;

class Hamiltonian {
    int nodeCount;
    int[] x;
    int[][] costAdjacencyMatrix;

    Hamiltonian() {
        Scanner input = new Scanner(System.in);
        System.out.print(" Enter the number of nodes : ");

        nodeCount = input.nextInt();
        costAdjacencyMatrix = new int[nodeCount + 1][nodeCount + 1];
        x = new int[nodeCount + 1];

        x[1] = 1;
        for (int i = 2; i <= nodeCount; i++) {
            x[i] = 0;
        }
        System.out.println(" Enter the cost adjacency matrix : ");
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                costAdjacencyMatrix[i][j] = input.nextInt();
            }
        }
    }

    public void nextVertex(int k) {
        int j = 1;
        while (true) {
            x[k] = (x[k] + 1) % (nodeCount + 1);
            if (x[k] == 0)
                return;
            if ( costAdjacencyMatrix[x[k - 1]][x[k]] == 1 )
                for (j = 1; j < k; j++)
                    if (x[j] == x[k])
                        break;
            if (j == k)
                if (k < nodeCount || (k == nodeCount && costAdjacencyMatrix[x[nodeCount]][1] == 1))
                    return;
        }
    }

    public void display(int k) {
        while (true) {
            nextVertex(k);
            if (x[k] == 0)
                return;
            if (k == nodeCount) {
                System.out.println(" Solution : ");
                for (int i = 1; i <= nodeCount; i++)
                    System.out.print(x[i] + " ");
                System.out.println(1);
            } else
                display(k + 1 );
        }
    }
}

class HamiltonianCycles {

    public static void main(String[] args ){

        Hamiltonian obj = new Hamiltonian();
        obj.display(2);
    }

}
