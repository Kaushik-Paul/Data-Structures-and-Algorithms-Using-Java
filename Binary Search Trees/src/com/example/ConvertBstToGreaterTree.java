package com.example;

public class ConvertBstToGreaterTree {

    private Node root;
    private int sum;

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

    public ConvertBstToGreaterTree() {
        this.root = null;
        this.sum = 0;
    }

    public void traversal() {
        inOrderTraversal(root);
        System.out.println();
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

    public void convertBstToGreaterTree() {
        convertBstToGreaterTreeHelper(this.root);
    }

    private void convertBstToGreaterTreeHelper(Node root) {
        if (root == null) {
            return;
        }
        convertBstToGreaterTreeHelper(root.right);
        int temp = root.value;
        root.value = sum;
        sum += temp;
        convertBstToGreaterTreeHelper(root.left);
    }

    public static void main(String[] args) {
        ConvertBstToGreaterTree bst = new ConvertBstToGreaterTree();
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
        bst.convertBstToGreaterTree();
        bst.traversal();
     }
}
