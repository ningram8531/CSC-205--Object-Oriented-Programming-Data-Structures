package com.company;

public class Cube extends Rectangle{
    private int length;

    public Cube(int length, int width, int height) {
        super(width, height);
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "length=" + length +
                '}';
    }
}
