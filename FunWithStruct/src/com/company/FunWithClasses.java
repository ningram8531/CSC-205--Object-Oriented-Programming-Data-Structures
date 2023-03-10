package com.company;

/**
 * Title: Fun With Classes
 * Desc: Explore how classes work
 */
public class FunWithClasses {

    public static void main(String[] args) {

        Point p1 = new Point(2,4);
        Point p1 = new Point();
        System.out.println(p1.getName());
        System.out.println(p1.getPointCount());
        Point p2 = new Point();
        System.out.println(p2.getName());
        System.out.println(p2.getPointCount());
        System.out.println(p1.getPointCount());

        p1.clearPointCount();

        System.out.println(Point.getHypotenuse());

    }
}
        /* Previous work
        Point q = new Point();
        Point p = new Point(4,8);
        Point badP = new Point(-2 , -4);
        badP.x = -2;
        badP.y = -4;

        System.out.println(badP);

        System.out.printf(p.toString());
        System.out.println(p);

        Point p1 = new Point(3,4);
        Point p2 = new Point(3,4);
        if(p1 == p2)
            System.out.println("p1 and p2 are equal");

        if(p1.equals(p2)) {
            System.out.println("p1 and p2 are the same point in the plane");
        }

         */



public class Point {

    private final String name = "";
    private int x;
    private int y;
    private static int pointCount = 0;


    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        if (x >= 0)
            this.x = x;
        else
            this.x = 0;
        if (y >= 0)
            this.y = y;
        else
            this.y = 0;
        pointCount++;
        name = "Point " + pointCount;
    }

    public String getName() {
        return name;
    }

    public int getPointCount() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x >= 0) {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y >= 0) {
            this.y = y;
        }
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public void randomizePoint() {
        this.x = (int) (Math.random() * 6 + 1);
        this.y = (int) (Math.random() * 6 + 1);
    }



        public static double getHypotenuse(int sideA, int sideB) {
            return (Math.hypot(sideA, sideB);
        }
}



