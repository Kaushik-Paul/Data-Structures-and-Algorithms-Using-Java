package com.example;

public class InvertBinaryTree {
    private Node root;

    public InvertBinaryTree() {
        root = null;
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
        System.out.print(root.data+" -> ");
        inOrderTraversal(root.right);
    }

    public void invertBinaryTree() {
        this.root = invertBinaryTreeHelper(this.root);
    }

    // O(n) time and O(n) space
    private Node invertBinaryTreeHelper(Node root) {
        if (root == null) {
            return null;
        }
        swapNode(root);
        invertBinaryTreeHelper(root.left);
        invertBinaryTreeHelper(root.right);
        return root;
    }

    private void swapNode(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();
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
        tree.invertBinaryTree();
        tree.traversal();
    }
}
