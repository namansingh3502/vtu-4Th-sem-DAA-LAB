import java.util.Scanner;

class TSP {
    int[][] costAdjacencyMatrix;
    int cityCount;

    TSP(){
        Scanner input = new Scanner(System.in);
        System.out.print( "Enter the number of city : " );
        cityCount = input.nextInt();
        System.out.println( "Enter the cost adjacency matrix : " );

        costAdjacencyMatrix = new int[cityCount+1][cityCount+1];

        for( int i = 1; i <= cityCount; i++ )
            for( int j = 1; j <= cityCount; j++ )
                costAdjacencyMatrix[i][j] = input.nextInt();

    }

    public int function(int[] path, int start) {
        int ccost;
        int[] mintour=new int[cityCount+1];
        int[] temp=new int[cityCount+1];
        if( start == cityCount-1 )
            return costAdjacencyMatrix[ path[cityCount-1] ][ path[cityCount] ] + costAdjacencyMatrix[ path[cityCount] ][1];

        int mincost=999;

        for(int i = start+1; i <= cityCount; i++ ) {
            for(int j = 1; j <= cityCount; j++) {
                temp[j] = path[j];
            }

            temp[start+1]=path[i];
            temp[i]=path[start+1];

            if(costAdjacencyMatrix[ path[start] ] [path[i] ] + ( ccost = function( temp,start+1 )) < mincost  ) {
                mincost=costAdjacencyMatrix[path[start]][path[i]]+ccost;
                for(int k=1;k<=cityCount;k++){
                    mintour[k]=temp[k];
                }
            }
        }
        for(int i=1;i<=cityCount;i++){
            path[i] = mintour[i];
        }
        return mincost;
    }

}

class TSPAlgo {
    public static void main(String[] args ){

        TSP tspAlgo = new TSP();

        int[] path = new int[tspAlgo.cityCount+1];
        for(int i = 1; i <= tspAlgo.cityCount; i++ )
            path[i] = i;

        int mincost = tspAlgo.function( path, 1 );

        System.out.println("tsp tour");
        for(int i = 1; i <= tspAlgo.cityCount; i++ )
            System.out.print(path[i] + "--->");
        System.out.println("1");
        System.out.println("Tourcost=" + mincost);

    }
}
