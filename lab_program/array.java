package com.lab_program;

import java.util.Scanner;

public class array {

    void driver(){
        int choice;
        boolean end = false;
        Scanner input = new Scanner( System.in );

        while( !end ){

            System.out.println( "-------MENU-------\n" );
            System.out.println( "1. 1-D\n2. 2-D\n3. 3-D\n4. Exit\n" );

            System.out.println( "\nEnter your choice : " );

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    oneD();
                    break;
                case 2:
                    twoD();
                    break;
                case 3:
                    threeD();
                    break;
                case 4:
                    end = true;
                    break;
                default:
                    System.out.print("\nInvalid input\n");
                    break;
            }
        }
    }

    void oneD(){
        int n;
        Scanner input = new Scanner( System.in );
        System.out.println("Enter the dimension of 1-d array: ");
        n = input.nextInt();

        int[] array_one = new int[n];

        System.out.println("Enter the elements : ");

        for( int i = 0; i < n; i++ ){
            array_one[i] = input.nextInt();
        }

        System.out.println("Elements in the array are: ");

        for( int i = 0; i < n; i++ ){
            System.out.println(array_one[i]);
        }

    }
    void twoD(){
        int n,m;
        Scanner input = new Scanner( System.in );
        System.out.println("Enter the dimension of 2-d array: ");
        m = input.nextInt();
        n = input.nextInt();


        int[][] array_one = new int[m][n];

        System.out.println("Enter the elements : ");


        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                array_one[i][j] = input.nextInt();
            }
        }

        System.out.println("Elements in the array are: ");

        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                System.out.print(array_one[i][j] + " \t");
            }
            System.out.print("\n");
        }

    }
    void threeD(){
        int a,b,c;
        Scanner input = new Scanner( System.in );
        System.out.println("Enter the dimension of 3-d array: ");
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();

        int[][][] array_one = new int[a][b][c];

        System.out.println("Enter the elements : ");

        for( int i = 0; i < a; i++ ){
            for( int j = 0; j < b; j++ ){
                for( int k = 0; k < c; k++ ){
                    array_one[i][j][k] = input.nextInt();
                }
            }
        }

        System.out.println("Elements in the array are: ");

        for( int i = 0; i < a; i++ ){
            for( int j = 0; j < b; j++ ){
                for( int k = 0; k < c; k++ ){
                    System.out.println(array_one[i][j][k] );
                }
                System.out.println();
            }
        }
    }
}
