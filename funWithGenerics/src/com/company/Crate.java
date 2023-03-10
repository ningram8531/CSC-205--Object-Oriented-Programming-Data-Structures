package com.company;

/**
 * Title: Crate
 */
import java.util.Arrays;

public class Crate<T> implements StackADT<T> {
    private T[] stack; //Holds an array of T
    private int top;
    private static final int CAP = 20;

    public Crate() {
        stack = (T[]) (new Object[Crate.CAP]);
        top = 0;
    }

    public void push(T element) {
        if(top < CAP) {
            stack[top] = element;
        }
    }

    public T pop() {
        if(top == 0) {
            return null;
        }
        else {
            top--;
            return stack[top];
        }
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public T peek() {
        if (top == 0) {
            return null;
        }
        else {
            return stack[top - 1];
        }
    }

    public int size() {
        return top;
    }
}
