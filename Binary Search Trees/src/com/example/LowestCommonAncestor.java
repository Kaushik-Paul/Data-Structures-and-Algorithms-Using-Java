package com.example;

public class LowestCommonAncestor {
    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public LowestCommonAncestor() {
        this.root = null;
    }

    public void traversal() {
        inOrderTraversal(root);
        System.out.println("NULL");
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " -> ");
        inOrderTraversal(root.right);
    }

    public void insertion(int newValue) {
       this.root = insertKey(this.root, newValue);
    }

    private Node insertKey(Node root, int newValue) {
        if (root == null) {
            return new Node(newValue);
        }
        if (root.value <= newValue) {
            root.right = insertKey(root.right, newValue);
        } else {
            root.left = insertKey(root.left, newValue);
        }
        return root;
    }

    public int lowestCommonAncestor(int value1, int value2) {
        return lowestCommonAncestorHelper(this.root, value1, value2);
    }

    // O(log n) time and O(log n) space
    private int lowestCommonAncestorHelper(Node root, int value1, int value2) {
        if (root == null) {
            return value1;
        }
        if (root.value < value1 && root.value < value2) {
            return lowestCommonAncestorHelper(root.right, value1, value2);
        }
        if (root.value > value1 && root.value > value2) {
            return lowestCommonAncestorHelper(root.left, value1, value2);
        }
        return root.value;
    }

    public static void main(String[] args) {
        LowestCommonAncestor bst = new LowestCommonAncestor();
        bst.insertion(10);
        bst.insertion(5);
        bst.insertion(15);
        bst.insertion(2);
        bst.insertion(5);
        bst.insertion(1);
        bst.insertion(13);
        bst.insertion(22);
        bst.insertion(14);
        bst.traversal();
        System.out.println("Lowest common Ancestor is: " + bst.lowestCommonAncestor(1, 2));
    }
}
