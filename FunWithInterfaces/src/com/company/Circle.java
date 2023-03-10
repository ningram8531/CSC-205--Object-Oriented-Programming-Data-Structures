package com.company;

public class Circle implements MetaData {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public String getConstants() {
        return MetaData.MAX_VALUE + "," +MetaData.MIN_VALUE;
    }

    public String getProjectName() {
        return MetaData.projectName
    }
}
