package com.lab_program;

import java.util.Scanner;

class Kruskal{

    int vertex,edges;
    int[][] costAdjacencyMatrix;
    int[][] minimumCostEdge;
    int minimumCost;
    int[] parentVertex;

    public Kruskal(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of vertex : ");
        vertex = input.nextInt();
        System.out.print("Enter the number of edges : ");
        edges = input.nextInt();

        costAdjacencyMatrix = new int[vertex+1][vertex+1];
        minimumCostEdge = new int[vertex+1][3];
        parentVertex = new int[vertex+1];
        minimumCost = 0;

        for( int i = 1; i <= vertex; i++ ){
            for( int j = 1; j <= vertex; j++ ){
                if( i == j ) costAdjacencyMatrix[i][j] = 0;
                else costAdjacencyMatrix[i][j] = 9999;
            }
        }
    }

    public void read(){
        Scanner input = new Scanner(System.in);
        int u,v,cost;

        System.out.println("Enter the edges as u, v and cost respectively : ");
        for( int i = 0; i < edges; i++ ){
            u = input.nextInt();
            v = input.nextInt();
            cost = input.nextInt();

            costAdjacencyMatrix[u][v] = costAdjacencyMatrix[v][u] = cost;
        }
    }

    public int find(int i){
        while(parentVertex[i] != 0 ) {
            i = parentVertex[i];
        }
        return i;
    }

    public boolean union( int u, int v){
        if(u!=v){
            parentVertex[v] = u;
            return true;
        }
        return false;
    }

    public void operation(){
        int u = 0, v = 0, a, b, edgeCount=0;
        for( int i = 1; i <= vertex; i++ ) parentVertex[i] = 0;

        while( edgeCount != vertex-1 ){
            int min  = Integer.MAX_VALUE;
            for( int i = 1; i < vertex; i++ ){
                for( int j = i+1; j <= vertex; j++ ){
                    if( costAdjacencyMatrix[i][j] < min ){
                        min = costAdjacencyMatrix[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }
            a = find(u);
            b = find(v);
            if( union(a,b)){
                edgeCount++;
                minimumCostEdge[edgeCount][1] = u;
                minimumCostEdge[edgeCount][2] = v;
                minimumCost += costAdjacencyMatrix[u][v];
            }
            costAdjacencyMatrix[u][v] = costAdjacencyMatrix[v][u] = Integer.MAX_VALUE;
        }
    }

    public void display(){
        System.out.println("Edges in minimum cost spanning tree are : ");
        for( int i = 1; i < vertex; i++ ){
            System.out.println( minimumCostEdge[i][1]  + " -- " + minimumCostEdge[i][2] );
        }
        System.out.println("Cost of minimum spanning tree is : " + minimumCost );
    }
}

public class KruskalAlgo {

    void KruskalMain(){
        Kruskal kruskal = new Kruskal();

        kruskal.read();

        kruskal.operation();

        kruskal.display();

    }

}
