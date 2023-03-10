package com.company;


public class StateTree {
    private int count;
    private Node root;

    public StateTree() {
        root = null;
        count = 0;
    }

    public void addElement(State newState) {
        Node newNode = new  Node((newState));
        if(root == null) {
            root = newNode;
            count++;
        } else {
            addElement(newNode, root);
        }
        count++;
    }

    public void addElement (Node newNode, Node subRoot) {
        if (newNode.state.compareTo(subRoot.state) < 0) {
            if (subRoot.left == null) { //Add it to the left
                subRoot.left = newNode;
                newNode.parent = subRoot;
            } else {
                addElement(newNode , subRoot.left);
            }
        } else {
            if (subRoot.right == null) { //No node to the right. Put it there!!
                subRoot.right = newNode;
                newNode.parent = subRoot;
            } else {
                addElement(newNode , subRoot.right);
            }
        }
    }
    //traverse the left subtree, visit the node, traverse right subtree
    public void inOrderTraversal () {
        if (root == null) {
            System.out.println("No states to traverse, must be in Canada??");
        } else {
            inOrderTraversal(root); //start traversal  at the root!
        }
    }

    public void inOrderTraversal (Node subRoot) {
        //Left subtree , visit right subtree
        if (subRoot != null) {
            inOrderTraversal(subRoot.left);
            System.out.println(subRoot.state);
            inOrderTraversal(subRoot.right);
        }
    }

    public void preOrderTraversal () {
        if (root == null) {
            System.out.println("No states to traverse, must be in Canada??");
        } else {
            preOrderTraversal(root); //start traversal  at the root!
        }
    }

    public void preOrderTraversal (Node subRoot) {
        //Left subtree , visit right subtree
        if (subRoot != null) {
            preOrderTraversal(subRoot.left);
            System.out.println(subRoot.state);
            preOrderTraversal(subRoot.right);
        }
    }

    public void postOrderTraversal () {
        if (root == null) {
            System.out.println("No states to traverse, must be in Canada??");
        } else {
            postOrderTraversal(root); //start traversal  at the root!
        }
    }

    public void postOrderTraversal (Node subRoot) {
        //Left subtree , visit right subtree
        if (subRoot != null) {
            postOrderTraversal(subRoot.left);
            postOrderTraversal(subRoot.right);
            System.out.println(subRoot.state);
        }
    }

    public State findMin () throws EmptyTreeException {
        State minState;
        Node subRoot;
        if (root == null) {
            throw new EmptyTreeException("Canada!!");
        } else {
            subRoot = root;
            while(subRoot.left != null) {
                subRoot = subRoot.left;
            }
            return subRoot.state;
        }
    }

    public State findMax () throws EmptyTreeException {
        State maxState;
        Node subRoot;
        if (root == null) {
            throw new EmptyTreeException("Canada!!");
        } else {
            subRoot = root;
            while (subRoot.right != null) {
                subRoot = subRoot.right;
            }
        }
        return subRoot.state;
    }

    public State findState (String name) {
        if (root == null) {
            throw new EmptyTreeException("Canada!!");
        } else {
            return findState(name , root);
        }
    }

    public State findState (String name, Node subRoot) {
        int cmp = subRoot.state.getStateName().compareTo(name);
        if (cmp == 0) {
            return subRoot.state;
        } else if (cmp < 0) {
            return findState(name , subRoot.left);
        } else {
            return findState(name , subRoot.right);
        }
    }


    class Node {
        State state;
        Node left;
        Node right;
        Node parent;

        public Node (State state) {
            left = right = parent = null;
            this.state  = state;
        }
    }
}
