package com.lab_program;

import java.util.Scanner;

class Stack{
    int[] stack;
    int top,size;

    Stack( int size ){
        this.stack = new int[size];
        this.top = size;
        this.size = size;
    }

    void push(){
        if( this.top == 0 ){
            System.out.println("Stack Overflow");
        }
        else {
            System.out.print("Enter the element to be insterted : ");
            Scanner input = new Scanner(System.in);
            this.top--;
            stack[this.top] = input.nextInt();
        }
    }

    void pop(){
        if( size == top ){
            System.out.println("Stack Underflow");
        }
        else{
            System.out.println("Element poped is : " + stack[top] );
            this.top++;
        }
    }

    void display(){
        if( this.top == this.size )  System.out.println("Stack is empty");

        for( int i = this.top; i < size; i++ )  System.out.print( stack[i] + " " );
        System.out.print("\n");
    }
}


public class Stacks {

    public static void main(String[] args ){
        Scanner input = new Scanner( System.in );
        int size;

        System.out.println("Enter the size of stack: ");
        size = input.nextInt();

        Stack stack = new Stack( size );

        int choice;
        boolean end = false;


        while( !end ){

            System.out.println( "-------MENU-------\n" );
            System.out.println( "1. Push\n2. Pop\n3. Display\n4.Exit\n" );

            System.out.println( "\nEnter your choice : " );

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    stack.push();
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
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

}
