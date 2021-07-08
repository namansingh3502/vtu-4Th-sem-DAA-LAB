package com.lab_program;

import java.util.Scanner;

class Dijkstra{

    int[][] costAdjacencyMatrix;
    boolean[] visited;
    int[] shortestPath;
    int source;
    int vertex;
    int edges;
    int[] nearArray;

    Dijkstra() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of vertices : ");
        vertex = input.nextInt();

        System.out.print("Enter the number of edges : ");
        edges = input.nextInt();

        costAdjacencyMatrix = new int[vertex+1][vertex+1];
        visited = new boolean[vertex+1];
        shortestPath = new int[vertex+1];
        nearArray = new int[vertex+1];

        for( int i = 1; i <= vertex; i++ ){
            for( int j = 1; j <= vertex; j++ ){
                if( i == j ) costAdjacencyMatrix[i][j] = 0;
                else costAdjacencyMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void read(){
        Scanner input = new Scanner(System.in);
        int u,v,cost;

        for( int i = 0; i < edges; i++ ){
            u = input.nextInt();
            v = input.nextInt();
            cost = input.nextInt();

            costAdjacencyMatrix[u][v] = costAdjacencyMatrix[v][u] = cost;
        }
    }

    public int minDistance(){
        int min = Integer.MAX_VALUE, index=-1;

        for( int i = 1; i <= vertex; i++ ){
            if (!visited[i] && shortestPath[i] <= min) {
                min = shortestPath[i];
                index = i;
            }
        }
        return index;
    }

    public void operation(){

        for (int i = 1; i <= vertex; i++) {
            shortestPath[i] = costAdjacencyMatrix[source][i];
            visited[i] = false;
            nearArray[i] = source;
        }

        shortestPath[source] = 0;

        for( int i = 2; i <= vertex; i++ ) {
            int nearestVertex = minDistance();
            visited[nearestVertex] = true;

            for (int j = 1; j <= vertex; j++) {
                if (!visited[j] && costAdjacencyMatrix[nearestVertex][j] != Integer.MAX_VALUE &&
                        shortestPath[nearestVertex] + costAdjacencyMatrix[nearestVertex][j] < shortestPath[j]) {

                    shortestPath[j] = shortestPath[nearestVertex] + costAdjacencyMatrix[nearestVertex][j];
                    nearArray[j] = nearestVertex;
                }
            }
        }
    }


    public void display(){
        System.out.println("Shorted path from source vertex " + source + " : ");

        for( int i = 1; i <= vertex; i++ ){
            System.out.println("vertex " + i + " : " + shortestPath[i] + "\t" );

            System.out.print ("Shortest Path : " + i + " ");
            int next = i;
            while( nearArray[next] != source ){
                System.out.print(" <- " + nearArray[next] );
                next = nearArray[next];
            }
            System.out.println(" <- " + source );
        }
    }
}

public class DijkstraAlgo {

    void DijkstraMain(){
        Scanner input = new Scanner(System.in);

        Dijkstra dijkstra = new Dijkstra();

        System.out.println("Enter the edges as u, v and cost respectively : ");
        dijkstra.read();

        System.out.println("Enter the source vertex : ");
        dijkstra.source = input.nextInt();
        dijkstra.operation();

        dijkstra.display();
    }
}
