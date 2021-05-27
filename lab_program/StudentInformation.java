package com.lab_program;

import java.util.Scanner;

class Student{
    String firstName,lastName, usn, program;
    long number;
    
    void create(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nEnter Name, USN, Program, Number respectively ");
        
        this.firstName = input.next();
        this.lastName = input.next();
        this.usn = input.next();
        this.program = input.next();
        this.number = input.nextLong();
    }
    
    void display(){
        System.out.println( "Name : " + this.firstName + " " + this.lastName );
        System.out.println( "USN : " + this.usn );
        System.out.println( "Program : " + this.program );
        System.out.println( "Number : " + this.number );
    }

}

public class StudentInformation {

    void studentInformationMain(){
        Scanner input = new Scanner(System.in);

        int n;
        System.out.print("Enter the number of students : ");
        n = input.nextInt();
    
        Student[] student = new Student[n];
        
        for( int i = 0; i < n; i++ ){
            student[i] = new Student();
            student[i].create();
        }

        System.out.println("\n\nStudent Information ");
        for( int i = 0; i < n; i++ ){
            System.out.println("\nStudent " + (i+1) );
            student[i].display();
        }
    }


}
