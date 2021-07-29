package com.lab_program;

import java.util.Scanner;

public class ExceptionProg {
    public static void main(String[] args ){
        Scanner input = new Scanner(System.in);
        int a,b;
        System.out.print("Enter the value of a and b : ");
        a = input.nextInt();
        b = input.nextInt();
        float ans;
        try {
            if( b == 0 ) throw new ArithmeticException(" Divide by Zero Error");
            ans = (float)a/b;
            System.out.println("Value of a/b = " + ans );
        }
        catch(ArithmeticException exception ){
            System.out.println("Error!!!");
            exception.printStackTrace();
        }
    }
}
