package com.company;

public class MYLL {

    private Node front;
    private Node rear;
    private int count;
    private long actions;

    public MYLL() {
        front = rear = null;
        count = 0;
        actions = 0;
    }

    public void add(int num) {
        Node newNode = new Node(num);
        if (count == 0) {
            front = rear = newNode;
            count++;
        } else {
            rear.next = newNode;  // Target is the node pointed to by rear the field next
            rear = newNode;  // Update rear to point at the newNode
            count++;
        }
    }

    public void clearActions() {
        actions = 0;
    }

    public long getActions() {
        return actions;
    }
    /* Due to time constraints, we will only add it to
       the front.    Assume that loc is 0
    */
    public void add(int loc, int num) {
        Node newNode = new Node(num);
        if (count == 0) {
            front = rear = newNode;
            count++;
        } else {
            newNode.next = front;
            front = newNode;
            count++;
        }
        actions += 4;
    }

    // set(2,3);  // set the 2nd one to 3
    public void set(int loc, int num) {
        Node index = front;
        for (int i = 0; i < loc; i++) {
            index = index.next;
            actions++;
        }
        index.x = num;
        actions++;
    }

    // Assuming loc is zero for now.
    public void remove(int loc) {
        front = front.next;
        count--;
        actions += 2;
    }

    // Inner Class. This is a tool in our Linked List
    class Node {
        int x;
        Node next;


        public Node(int x) {
            this.x = x;
            next = null;
        }
    }
}
