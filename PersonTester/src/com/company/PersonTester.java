package com.company;

import java.util.Scanner;

/**
 * Author: Nick Ingram
 *Program ID:  PersonTester.java
 *Date : 09/28/2022
 *Brief Description:
 Tester program that test Person object and its methods
 Person class definition can be found in Person.java
 **/

public class PersonTester {

        public static void main(String[] args) {
                Address addr = new Address
                        ("123 E. Main", "Phx", "AZ", "85515");
                Person p1 = new Person("Minnie",1928,addr);

                Address addr2 = new Address
                        ("456 E. First","Mesa","AZ", "85025");
                Person p2 = new Person("Mickey",1928, addr2);

                System.out.println(p1);
                System.out.println(p2);

                p1.setAddress(new Address("Down by the river","In a van", "AZ", "00000"));
                System.out.println(p1);

                System.out.println("Hey Mickey, can I have your address?");
                Address hack = p1.getAddress();


        }
}
/**
            String pName;
            int pBirthYear;
            int currentYear;
            int count = 1;

            @SuppressWarnings("resource")
            Scanner scan = new Scanner(System.in);

            System.out.println( "Creating Person objects");
            System.out.println( "-----------------------" );

            System.out.println( "Enter the current year: ");
            currentYear = scan.nextInt();
            scan.nextLine(); //reads the dangling newline

            //First Person Object
            System.out.println( "\nPerson #" + count++);
            System.out.println( "Enter a name please: ");
            pName = scan.nextLine(); //allows you to enter multiple words

            System.out.println( "Enter a birth year : ");
            pBirthYear = scan.nextInt();
            scan.nextLine(); //reads the dangling newline character

            Person teacher = new Person(pName, pBirthYear); //create a Person object
            System.out.println( "\nThe Person data is:" );
            System.out.println(teacher);
            System.out.println("\t age: " + teacher.calculateAge(currentYear));

            //Second Person Object
            System.out.println( "\nPerson #" + count++);
            System.out.println( "Enter a name please: ");
            pName = scan.nextLine(); //allows you to enter multiple words

            System.out.println( "Enter a birth year : ");
            pBirthYear = scan.nextInt();

            Person student = new Person(pName, pBirthYear); //create another Person object
            System.out.println( "\nThe Person data is:" );
            System.out.println(student);
            System.out.println("\t age: " + student.calculateAge(currentYear));

            //Below call the equals method to see if both persons are of the same age
            //display appropriate message in both cases.
            if(teacher.equals(student))
            {
                System.out.println("Teacher " + teacher.getName() + " is almost the same age as " +
                        "Student " + student.getName());
            }
            else
            {
                System.out.println("Teacher " + teacher.getName() + " is NOT the same age as " +
                        "Student " + student.getName());
            }

        }

    }
**/