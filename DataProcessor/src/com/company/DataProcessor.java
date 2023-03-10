package com.company;

import java.io.*;
import java.util.Scanner;

public class DataProcessor {

    public static void main(String[] args) {
	String inputData;
    String [] parts;
    String fname, lname;
    int grade;

        try {
        FileInputStream fileStream =
                new FileInputStream("../StudentData/StudentData.txt");
        Scanner stdin = new Scanner(fileStream);

        while(stdin.hasNext()){
            inputData = stdin.nextLine();
            parts = inputData.split(",");
            //Now do something with data
            System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
        }
        stdin.close();
            //We dont want data recorder to overwrite our files

            File file = new File("../StudentData/StudentData.txt");
            if(file.renameTo(new File("../StudentData/Archive/StudentDataDate.txt"))) {
                System.out.println("File removed successfully");
            }
            else {
                System.err.println("Bad moon rising");
            }
    }
    catch (FileNotFoundException e) {
        System.out.println("File not found");
    }
    }
}
