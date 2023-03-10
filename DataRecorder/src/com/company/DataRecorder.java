package com.company;

import java.util.Scanner;
import java.io.*;
import java.io.FileOutputStream;
public class DataRecorder {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String input = "";
        String name;
        int grade;
        String [] stuff;
        FileOutputStream fileStream = null;
        PrintWriter fileOut = null;
        try {
            //We need to open our file. Before anything else
            fileStream = new FileOutputStream("../StudentData/StudentData.txt"); //Connects to the hard drive.
            fileOut = new PrintWriter(fileStream);//This allows us to read all the data.

            System.out.println("Enter a series of names and test" +
                    "scores. Enter quit to exit.");

            System.out.println("Enter a name and grade");
            input = stdin.nextLine();
            while (!input.equalsIgnoreCase("quit")) {
                stuff = input.split(" "); //Splits a string into an array
                if (stuff.length != 3) {
                    System.out.println("Invalid entry");
                } else {
                    try {
                        grade = Integer.parseInt(stuff[2]); // Convert 3rd value to an int
                        //If I got here, I have valid data
                        fileOut.println(stuff[0] + "," +
                                        stuff[1] + "," +
                                        stuff[2]);
                    } catch (Exception e) {
                        System.out.println("Invalid entry");
                    }
                }
                System.out.println("Enter a name and a grade");
                input = stdin.nextLine();
            }
            fileOut.close();
        }
        catch (FileNotFoundException e ) {
            System.err.println("File not found, exiting stage left");
        }
    }
}

/*
What is an indeterminate loop vs determinate loop

Determinate is when you know how many times a loop will iterate.
Indeterminate is when you don't know
 */
