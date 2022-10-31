package com.example;

public class TrimBinarySearchTree {

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

    public TrimBinarySearchTree() {
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

    public void trimBst(int low, int high) {
        this.root = trimBstHelper(this.root, low, high);
    }

    // O(log n) time and O(log n) space
    private Node trimBstHelper(Node root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.value > high) {
            return trimBstHelper(root.left, low, high);
        }
        if (root.value < low) {
            return trimBstHelper(root.right, low, high);
        }
        root.left = trimBstHelper(root.left, low, high);
        root.right = trimBstHelper(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        TrimBinarySearchTree bst = new TrimBinarySearchTree();
        bst.insertion(3);
        bst.insertion(0);
        bst.insertion(2);
        bst.insertion(1);
        bst.insertion(4);
        bst.traversal();
        bst.trimBst(1, 3);
        bst.traversal();
    }
}
