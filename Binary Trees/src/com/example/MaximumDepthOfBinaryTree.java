package com.example;

public class MaximumDepthOfBinaryTree {

    private Node root;

    public MaximumDepthOfBinaryTree() {
        root = null;
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
        System.out.print(root.data+" -> ");
        inOrderTraversal(root.right);
    }

    public void calculateNodeDepth() {
        System.out.println("The Maximum Depth of Binary Tree is: " + calculateNodeDepthHelper(this.root, 0));
    }

    // O(n) time and O(n) space
    private int calculateNodeDepthHelper(Node root, int maximumDepth) {
        if (root == null) {
            return maximumDepth;
        }
        maximumDepth++;
        return Math.max(calculateNodeDepthHelper(root.left, maximumDepth), calculateNodeDepthHelper(root.right, maximumDepth));
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.traversal();
        tree.calculateNodeDepth();
    }
}
