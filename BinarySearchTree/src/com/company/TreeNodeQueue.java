package com.company;

public class TreeNodeQueue
{
    private QueueNode front = null,
            rear = null;

    public void enQueue(Node newby) {
        QueueNode newNode = new QueueNode(newby);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Node deQueue() {
        if (front == null) {
            return null;
        } else {
            Node returnNode = front.data;  // Grab the node in the front of the line
            front = front.next;
            return returnNode;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

    class QueueNode {
        Node data;   // This is a tree node!
        QueueNode next;

        public QueueNode(Node newby) {
            data = newby;
            next = null;
        }
    }
}
