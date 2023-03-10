package com.company;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Title: Let's investigate generics. Create a box and crate.
 */
public class Main {

    public static void main(String[] args) {
	//We want a box that holds a widget
        Box b1 = new Box(42);
        Box b2 = new Box("FortyTwo");
        Box b3 = new Box(new Point(2,4));

        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.add(b1);
        boxes.add(b2);
        boxes.add(b3);

        for(Box b : boxes) {
            System.out.println(b);
        }

    }
}

class Point {
    int x;
    int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

