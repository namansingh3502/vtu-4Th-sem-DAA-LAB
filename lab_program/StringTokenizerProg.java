package com.lab_program;

import java.util.Scanner;
import java.util.StringTokenizer;

class Customer{
    String customerName, date;

    public Customer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter customer name : ");
        this.customerName = input.next();
        System.out.println("Enter date : ");
        this.date = input.next();
    }
    public String toString(){
        String newString = customerName + " ";
        StringTokenizer tokenizer = new StringTokenizer(date,"/");

        while( tokenizer.hasMoreTokens() ){
            newString = newString + tokenizer.nextToken();
            if( tokenizer.hasMoreTokens() ) {
                newString = newString + ",";
            }
        }
        return newString;
    }
}
public class StringTokenizerProg {
    public static void main(String[] args ){
        Customer customer = new Customer();
        Scanner input = new Scanner(System.in);

        System.out.print("The customer details are : ");
        String newString = customer.toString();
        System.out.print(newString);
    }
}
