package com.company;

public class BoxInt {
    private final int SERIAL_NUMBER;
    private int theInt;
    private static int widgetCount = 10000;

    public BoxInt(int widgetCount, int theInt) {
        widgetCount++;
        this.SERIAL_NUMBER = widgetCount;
        this.theInt = theInt;
    }

    public int getTheInt() {
        return theInt;
    }

    public static int getWidgetCount() {
        return widgetCount;
    }

    public void setTheInt(int theInt) {
        this.theInt = theInt;
    }

    public static void setWidgetCount(int widgetCount) {
        BoxInt.widgetCount = widgetCount;
    }
}
