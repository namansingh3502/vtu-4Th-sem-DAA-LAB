package com.lab_program;

import java.util.Scanner;

class Staff{
    private String staffId;
    private String name;
    private Long phone;
    private Long salary;

    public void read_basic(){
        Scanner input = new Scanner( System.in );
        System.out.println("Enter Name, Staff Id, Phone, Salary respectively");
        this.name = input.nextLine();
        this.staffId = input.next();
        this.phone = input.nextLong();
        this.salary = input.nextLong();
    }

    public void display_basic(){
        System.out.println( "Name : " + this.name);
        System.out.println( "Staff Id : " + this.staffId );
        System.out.println( "Phone : " + this.phone );
        System.out.println( "Salary : " + this.salary );
    }

}

class Teaching extends Staff{
    private String domain;
    private String publications;

    public Teaching(){
        this.read_basic();
        System.out.println("Enter Domain, Publication respectively");
        Scanner input = new Scanner( System.in );
        this.domain = input.next();
        this.publications = input.next();
    }
    void display(){
        this.display_basic();
        System.out.println( "Domain : " + this.domain );
        System.out.println( "Publication : " + this.publications );
        System.out.println();
    }
}

class Technical extends Staff{
    private String skills;

    public Technical(){
        this.read_basic();
        System.out.println("Enter Skill respectively");
        Scanner input = new Scanner( System.in );
        this.skills = input.next();
    }
    void display(){
        this.display_basic();
        System.out.println( "Skill : " + this.skills );
        System.out.println();

    }
}

class Contract extends Staff{
    private String period;

    public Contract(){
        this.read_basic();
        System.out.println("Enter Period respectively");
        Scanner input = new Scanner( System.in );
        this.period = input.next();
    }
    void display(){
        this.display_basic();
        System.out.println( "Period : " + this.period );
        System.out.println();
    }
}

public class StaffInformation {

    void StaffInformationMain() {
        Scanner input = new Scanner( System.in );

        int teaching_staff_count=0, technical_staff_count=0,contract_staff_count=0;

        Teaching[] teachingStaff = new Teaching[10];
        Technical[] technicalStaff = new Technical[10];
        Contract[] contractStaff = new Contract[10];


        int choice ;
        boolean run = true;

        while( run ){
            System.out.println("-----------MENU-----------");
            System.out.println("1. Add teaching staff");
            System.out.println("2. Add technical staff");
            System.out.println("3. Add contract staff");
            System.out.println("4. Display Teaching staff");
            System.out.println("5. Display Technical staff");
            System.out.println("6. Display Contract staff");
            System.out.println("7. Exit" );

            choice = input.nextInt();

            switch (choice){
                case 1:
                    if( teaching_staff_count == 10 ) {
                        System.out.println("Storage full");
                    }
                    else {
                        teachingStaff[teaching_staff_count] = new Teaching();
                        teaching_staff_count++;
                    }
                    break;
                case 2:
                    if( technical_staff_count == 10 ) {
                        System.out.println("Storage full");
                    }
                    else {
                        technicalStaff[technical_staff_count] = new Technical();
                        technical_staff_count++;
                    }
                    break;
                case 3:
                    if( contract_staff_count == 10 ) {
                        System.out.println("Storage full");
                    }
                    else {
                        contractStaff[contract_staff_count] = new Contract();
                        contract_staff_count++;
                    }
                    break;
                case 4:
                    if( teaching_staff_count == 0 ) {
                        System.out.println("No Staff Record");
                    }
                    else {
                        System.out.println("\nDetails of Teaching Staff ");
                        for (int i = 0; i < teaching_staff_count; i++) {
                            teachingStaff[i].display();
                        }
                    }
                    break;
                case 5:
                    System.out.println("\nDetails of Technical Staff ");
                    for (int i = 0; i < technical_staff_count; i++) {
                        technicalStaff[i].display();
                    }
                    break;
                case 6:
                    if( contract_staff_count == 0 ) {
                        System.out.println("No Staff Record");
                    }
                    else {
                        System.out.println("\nDetails of Contract Staff ");
                        for (int i = 0; i < contract_staff_count; i++) {
                            contractStaff[i].display();
                        }
                    }
                    break;
                case 7:
                    run = false;
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }
}
/*

public class StaffInformation {

    void StaffInformationMain(){

        Scanner input = new Scanner( System.in );

        int teaching_staff_count, technical_staff_count,contract_staff_count;

        System.out.print("Enter the number of Teaching staff : ");
        teaching_staff_count = input.nextInt();

        Teaching[] teachingStaff = new Teaching[teaching_staff_count];

        for( int i = 0; i < teaching_staff_count; i++  ){
            System.out.println("Enter First name, Last name, Staff Id, Phone, Salary respectively");
            teachingStaff[i] = new Teaching();
        }

        System.out.print("Enter the number of Technical staff : ");
        technical_staff_count = input.nextInt();

        Technical[] technicalStaff = new Technical[technical_staff_count];

        for( int i = 0; i < technical_staff_count; i++  ){
            System.out.println("Enter First name, Last name, Staff Id, Phone, Salary respectively");
            technicalStaff[i] = new Technical();
        }

        System.out.print("Enter the number of Teaching staff : ");
        contract_staff_count = input.nextInt();

        Contract[] contractStaff = new Contract[contract_staff_count];

        for( int i = 0; i < contract_staff_count; i++  ){
            System.out.println("Enter First name, Last name, Staff Id, Phone, Salary, Skill respectively");
            contractStaff[i] = new Contract();
        }

        if( teaching_staff_count > 0 ) {
            System.out.println("\nDetails of Teaching Staff ");

            for (int i = 0; i < teaching_staff_count; i++) {
                teachingStaff[i].display();
            }
        }

        if( technical_staff_count > 0 ) {
            System.out.println("\nDetails of Technical Staff ");

            for (int i = 0; i < technical_staff_count; i++) {
                technicalStaff[i].display();
            }
        }

        if( contract_staff_count > 0 ) {
            System.out.println("\nDetails of Contract Staff ");

            for (int i = 0; i < contract_staff_count; i++) {
                contractStaff[i].display();
            }
        }
    }


}
 */
