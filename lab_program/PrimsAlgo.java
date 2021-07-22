package com.lab_program;


import java.util.Scanner;

class Prims {

    int vertex;
    int[][] costAdjacencyMatrix;
    int[][] minimumCostEdge;
    int minimumCost;

    public Prims(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of vertex : ");
        vertex = input.nextInt();

        costAdjacencyMatrix = new int[vertex+1][vertex+1];
        minimumCostEdge = new int[vertex+1][3];
        minimumCost = 0;
    }

    public void read(){
        System.out.println("Enter cost adjacency matrix : ");
        Scanner input = new Scanner(System.in);
        for( int i = 1; i <= vertex; i++ ){
            for( int j = 1; j <= vertex; j++ ){
                costAdjacencyMatrix[i][j] = input.nextInt();
            }
        }
    }

    public void operation(){
        int near[] = new int[vertex+1];
        int d[] = new int[vertex+1];
        int min=9999,k=0,l=0;
        for(int i=1;i<vertex;i++)
            for(int j=i+1;j<=vertex;j++)
            {
                if(costAdjacencyMatrix[i][j]<min)
                {
                    min = costAdjacencyMatrix[i][j];
                    k=i;
                    l=j;
                }
            }
        near[k]=near[l]=0;
        minimumCostEdge[1][1]=k;
        minimumCostEdge[1][2]=l;
        minimumCost += minimumCostEdge[k][l];

        for(int v=1;v<=vertex;v++)
        {
            if(costAdjacencyMatrix[v][k]<costAdjacencyMatrix[v][l])
                near[v]=k;
            else
                near[v]=l;
            d[v]=costAdjacencyMatrix[v][near[v]];
        }

        for(int i=2;i<=vertex-1;i++)
        {
            int j=0,m=9999;
            for(int v=1;v<=vertex;v++)
            {
                if(near[v]!=0 && d[v]!=0 && d[v]<m)
                {
                    m=d[v];
                    j=v;
                }
            }
            minimumCostEdge[i][1]=j;
            minimumCostEdge[i][2]=near[j];
            minimumCost+=d[j];
            near[j]=0;
            for(int v=1;v<=vertex;v++)
                if(near[v]!=0 && d[v]>costAdjacencyMatrix[v][j])
                {
                    d[v]=costAdjacencyMatrix[v][j];
                    near[v]=j;
                }

        }
    }

    public void display(){
        System.out.println("Edges of minimum cost spanning tree are : ");
        for( int i = 1; i < vertex; i++ ){
            System.out.println( minimumCostEdge[i][1] + " --> " + minimumCostEdge[i][2]);
        }
        System.out.println("Cost of the minimum spanning tree is " + minimumCost);
    }

}


public class PrimsAlgo {

    void PrimsMain(){
        Prims prims = new Prims();

        prims.read();
        prims.operation();
        prims.display();
    }
}