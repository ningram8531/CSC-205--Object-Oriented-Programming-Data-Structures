package com.company;

public class funWithTrees {

    public static void main(String[] args) {
	    StateTree tree = new StateTree();

        tree.addElement(new State("Kansas" , "Lincoln"));
        tree.addElement(new State("Ohio" , "Columbus"));
        tree.addElement(new State("Georgia" , "Atlanta"));
        tree.addElement(new State("Colorado" , "Denver"));
        tree.addElement(new State("Maine" , "Augusta"));

        System.out.println("In order traversal");
        tree.inOrderTraversal();
        System.out.println("Pre order traversal");
        tree.preOrderTraversal();
        System.out.println("Post order traversal");
        tree.postOrderTraversal();
    }
}
