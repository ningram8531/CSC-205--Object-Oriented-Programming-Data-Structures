package com.company;

public class BST1 {

    public Node root;
    public int nodecnt;
    public char nextdata = 'A';

    public BST1 inOrderTraversal(Node node) {
        if (root == null) return this;
        if (node == null) node = root;
        if (node.left != null)
            inOrderTraversal(node.left);
        node.visit();
        if (node.right != null)
            inOrderTraversal(node.right);
        return this;
    }

    /*
     * preOrder.  Visit Node, Visit Left, Visit Right
     */
    public BST1 preOrderTraversal(Node node) {
        if (root == null) return this;
        if (node == null) node = root;
        node.visit();                     // Visit the node
        if (node.left != null)            // Visit the left subtree
            preOrderTraversal(node.left);
        if (node.right != null)
            preOrderTraversal(node.right); // Visit the right subtree
        return this;
    }

    /*
     * Visit Left Tree, Visit Right Tree, Visit Node
     */
    public BST1 postOrderTraversal(Node node) {
        if (root == null) return this;
        if (node == null) node = root;
        if (node.left != null)            // Visit the left subtree
            postOrderTraversal(node.left);
        if (node.right != null)
            postOrderTraversal(node.right); // Visit the right subtree
        node.visit();                     // Visit the node
        return this;

    }

    /*
     * We Built our own Queue and used it to follow the algorithm below!
     */
    public BST1 levelOrderTraversal(Node node) {
        if (node == null)
            node = root;  // If null is passed in, set it to the root
        /*
         * the algorithm...
         */
        //* + instantiate a queue
        TreeNodeQueue tnq = new TreeNodeQueue();
        //* + enqueue root node
        tnq.enQueue(node);
        //* + while queue not empty
        while (!tnq.isEmpty()) {
            //*   - node = dequeue
            Node frontNode = tnq.deQueue();
            //*   - visit node (print)
            frontNode.visit();
            //*   - enqueue node's children (left then right)
            if (frontNode.left != null) {
                tnq.enQueue(frontNode.left);
            }
            if (frontNode.right != null) {
                tnq.enQueue(frontNode.right);
            }
        }
        return this;
    }

    public BST1 insert(int key) {
        if (root == null) {
            root = new Node(key, null, nextdata++);
            nodecnt++;
            return this;
        }
        return insert(key, root);
    }

    public BST1 insert(int key, Node parent) {
        if (key == parent.key) return this;
        nodecnt++;
        if (key < parent.key) {
            if (parent.left == null) {
                parent.left = new Node(key, parent, nextdata++);
                return this;
            }
            return insert(key, parent.left);
        }
        if (parent.right == null) {
            parent.right = new Node(key, parent, nextdata++);
            return this;
        }
        return insert(key, parent.right);
    }

    /*
     * TBI (To Be Implemented)...
     */
    public BST1 delete(int key) {
        /*
         * three cases:  node being deleted has zero kids; node being
         * deleted has one child; node being deleted has two children
         */

        Node deadNode = find(key);  // First things first, we need to find the key to see if it needs to be deleted
        if (deadNode == null)
            return this;
        if (deadNode.left == null && deadNode.right == null) {
            deleteLeaf(deadNode);
            return this;
        } else if (deadNode.left == null || deadNode.right == null) {
            deleteSingleParent(deadNode);
            return this;
        } else {
            deleteInnerNode(deadNode);
            return this;
        }
    }


    // Let's write a helper method that returns true if the node is a left child
    private boolean isLeftChild(Node n) {
        if (n.parent.left == n )
            return true;
        else
            return false;
    }

    private void deleteLeaf(Node deadNode) {
        if (deadNode == root) {  // If the deadNode is the only one left in the tree
            root = null;  // Simply kill the tree.  With a hug.
        } else if (isLeftChild(deadNode)) {       // If the node is a left child
            deadNode.parent.left = null;   // Delete the link from the parent to thier left child
        } else {
            deadNode.parent.right = null;
        }
    }

    private void deleteSingleParent(Node deadNode) {
        // When deleting, we always have to worry about the root.  Because it has no parent.
        if (deadNode == root) {
            if (root.left != null){
                root = root.left;
            } else {
                root = root.right;
            }
        } else if (isLeftChild(deadNode)) {  // The deadNode is a left child
            if (deadNode.left != null) {  // The deadNode has a left child
                deadNode.parent.left = deadNode.left; // Set the parent to point at the left child of the deadnode
            } else {
                deadNode.parent.left = deadNode.right; // The parent points at the right child of the deadNode
            }
        } else {  // The deadNode is a right child.
            if (deadNode.left != null) {  // The deadNode has a left child
                deadNode.parent.right = deadNode.left; // Set the parent to point at the left child of the deadnode
            } else {
                deadNode.parent.right = deadNode.right; // The parent points at the right child of the deadNode
            }
        }
    }

    /**
     *  Now, if the node has two children, we have to find a replacement.
     */
    private void deleteInnerNode(Node deadNode) {
        // We have to find the next smallest node in the list.
        // One step to the left and then all the way to the right.
        Node minNode = min(deadNode.left);  // We know there are two children.  So let's use our min method.
        // It will either be a leaf or a node with one parent.

        deadNode.data = minNode.data;
        deadNode.key = minNode.key;    // I am going to make minNode the deadNode now.
        if (minNode.left == null && minNode.right == null)
            deleteLeaf(minNode);  // minNode becomes the deadNode.  Kill it.
        else
            deleteSingleParent(minNode);  // minNode must be removed!!!
    }





    public Node find(int key) {
        if (root == null) return null;
        return find(key, root);
    }

    /*
     * This is passed the root or subroot and the key to search for.
     * We are going to do it using recursion.
     */
    public Node find(int key, Node n) {
        if (n == null) {
            return null;   // The key was not found!
        } else if (key == n.key) {
            return n;   // We found it!!
        } else if (key < n.key) {
            return find(key, n.left);  // Recursive search of the left subtree
        } else {
            return find(key, n.right); // Recursive search of the right subtree
        }
    }

    /*
     * This is passed the root of our tree (or subtree)
     * to find the min, we just go as far to the left as possible!!
     */
    public Node min(Node n) {

        while (n.left != null) {
            n = n.left;
        }
        return n;  //
    }

    /*
     * To find the max of a tree or subtree, then traverse as far to the right
     * as possible.
     */
    public Node max(Node n) {
        while (n.right != null)
            n = n.right;
        return n;  // This should reference the maximum node in the tree.
    }

    /*
     * BST1.main(String[] argv) is used to test class BST1
     */
    public static void main(String[] argv) {

        int[] a = { 30, 20, 40, 18, 25, 24, 27, 23, 21, 22, 29, 35, 42 };

        // testing delete...
        for (int i = 0; i < a.length; i++)
            delete(init(a), a[i]);

        // testing min and max...
        BST1 tree = init(a);
        System.out.println("min = " + tree.min(tree.root).key +
                "; max = " + tree.max(tree.root).key);

        // testing find...
        int[] f = { a[0], a[a.length-1], 205, a[a.length/2] };
        for (int i = 0; i < f.length; i++)
            System.out.println("find(" + f[i] + "): " +
                    ((tree.find(f[i]) == null) ?
                            "not found" : "found"));

        // testing level-order traversal...
        System.out.println("\nlevel-order traversal:");
        tree.levelOrderTraversal(null);

        // testing deleting/traversal small trees (1, 2, 3 nodes)...
        deleteSmallTrees();

    }

    static BST1 init(int[] a) {
        BST1 tree = new BST1();
        System.out.print("\ninputs: ");
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        return tree;
    }

    static void delete(BST1 tree, int key) {
        tree.preOrderTraversal(null);
        System.out.println("\ndelete(" + key + ")...");
        tree.delete(key);
        tree.preOrderTraversal(null);
    }

    static void deleteSmallTrees() {

        BST1 t = new BST1();
        System.out.println("\ninputs: 10");
        t.insert(10);
        t.levelOrderTraversal(null);
        System.out.println("\ndelete(10)...");
        t.delete(10);
        if (t.root != null) {
            System.out.println("\t??? there should be no traversal");
            t.levelOrderTraversal(null);
        } else
            System.out.println("\tempty tree (no traversal)");

        t = new BST1();
        System.out.println("\ninputs: 10 5");
        t.insert(10);
        t.insert(5);
        t.inOrderTraversal(null);
        System.out.println("\ndelete(10)...");
        t.delete(10);
        t.inOrderTraversal(null);

        t = new BST1();
        System.out.println("\ninputs: 10 15");
        t.insert(10);
        t.insert(15);
        t.inOrderTraversal(null);
        System.out.println("\ndelete(10)...");
        t.delete(10);
        t.inOrderTraversal(null);

        t = new BST1();
        System.out.println("\ninputs: 10 15 5");
        t.insert(10);
        t.insert(15);
        t.insert(5);
        t.inOrderTraversal(null);
        System.out.println("\ndelete(10)...");
        t.delete(10);
        t.inOrderTraversal(null);

    }

    static void printTraversals(BST1 tree) {
        System.out.println("\nin-order:");
        tree.inOrderTraversal(null);

        System.out.println("\npre-order traversal:");
        tree.preOrderTraversal(null);

        System.out.println("\npost-order traversal:");
        tree.postOrderTraversal(null);

        System.out.println("\nlevel-order traversal:");
        tree.levelOrderTraversal(null);
    }
}


// Almost like what we've done in class
class Node {

    public int key;
    public char data;
    public Node parent;
    public Node left;
    public Node right;

    public Node(int k, Node p, char d) {
        this(k, p, d, null, null);
    }

    public Node(int k, Node p, char d, Node l, Node r) {
        key = k;
        parent = p;
        data = d;
        right = r;
        left = l;
    }

    public void visit() {
        System.out.print("\t" + key);
        if (parent == null)
            System.out.print(" (root node)");
        else
            System.out.print(" (parent: " + parent.key + ")");
        System.out.print(" left: ");
        if (left == null) System.out.print("na");
        else System.out.print(left.key);
        System.out.print("; right: ");
        if (right == null) System.out.print("na");
        else System.out.print(right.key);
        System.out.println("; " + data);
    }
}
