package com.example;

public class DiameterOfBinaryTree {

    private Node root;
    private int diameter = -1;

    public DiameterOfBinaryTree() {
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

    public void diameterOfBinaryTree() {
        dfs(this.root);
        System.out.println("The Diameter of the Binary Tree is: " + diameter);
    }

    // O(n) time and O(n) space
    private int dfs(Node root) {
        if (root == null) {
            return -1;
        }
        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);

        diameter = Math.max(diameter, (left + right));
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.traversal();
        tree.diameterOfBinaryTree();
    }
}
