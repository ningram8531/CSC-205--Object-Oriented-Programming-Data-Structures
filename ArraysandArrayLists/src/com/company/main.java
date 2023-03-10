package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class main
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        //ArrayList<Integer> myInts = new ArrayList<Integer>(); // Dummy array list to demo ops
        //MYAL myInts = new MYAL();
        MYLL myInts = new MYLL();
        int numElem;                                          // User defined array size
        int numOps;                                           // User defined number of inserts
        int i;                                                // Loop index

        System.out.print("\nEnter initial ArrayList size: ");
        numElem = scnr.nextInt();

        System.out.print("Enter number of ArrayList adds: ");
        numOps = scnr.nextInt();

        System.out.print("  Adding elements to ArrayList...");

        myInts.clearActions();
        //myInts.clear();
        for (i = 0; i < numElem; ++i) {
            myInts.add(0); //
        }

        System.out.println("done. Actions = " + myInts.getActions());
        System.out.print("  Writing to each element...");
        myInts.clearActions();

        for (i = 0; i < numElem; ++i) {
            myInts.set(i, (int)(Math.random() * 777 + 1)); // Any value
        }

        System.out.println("done. Actions = " + myInts.getActions());
        System.out.print("  Doing " + numOps + " additions at the end...");
        myInts.clearActions();

        for (i = 0; i < numOps; ++i) {
            myInts.add((int)(Math.random() * 888 + 1)); // Any value
        }

        System.out.println("done. Actions = " + myInts.getActions());
        System.out.print("  Doing " + numOps + " additions at index 0...");
        myInts.clearActions();

        for (i = 0; i < numOps; ++i) {
            myInts.add(0, (int)(Math.random() * 444 + 1));
        }
        System.out.println("done. Actions = " + myInts.getActions());

        System.out.print("  Doing " + numOps + " removes...");
        myInts.clearActions();

        for (i = 0; i < numOps; ++i) {
            myInts.remove(0);
        }
        System.out.println("done. Actions = " + myInts.getActions());

    }
}
