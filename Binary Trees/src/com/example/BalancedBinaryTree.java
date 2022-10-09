package com.example;

public class BalancedBinaryTree {

    private Node root;

    private static class Pair {
        boolean balanced;
        int height;

        public Pair(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }


    public BalancedBinaryTree() {
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

    public void isBalancedBinaryTree() {
        Pair isBalanced = balanceBinaryTreeHelper(this.root);
        if (isBalanced.balanced) {
            System.out.println("The Binary Tree is a Balanced Binary Tree");
        } else {
            System.out.println("The Binary Tree is not a Balanced Binary Tree");
        }
    }

    // O(n) time and O(n) space
    private Pair balanceBinaryTreeHelper(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }
        Pair leftSubTree = balanceBinaryTreeHelper(root.left);
        Pair rightSubTree = balanceBinaryTreeHelper(root.right);
        boolean balanced = leftSubTree.balanced && rightSubTree.balanced && (Math.abs(leftSubTree.height - rightSubTree.height) <= 1);
        return new Pair(balanced, 1 + Math.max(leftSubTree.height, rightSubTree.height));
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
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
        tree.isBalancedBinaryTree();
    }
}
