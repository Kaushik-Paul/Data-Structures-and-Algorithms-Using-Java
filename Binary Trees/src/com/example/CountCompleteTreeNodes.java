package com.example;

public class CountCompleteTreeNodes {

    private Node root;

    public CountCompleteTreeNodes() {
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


    // O(2log n) time and O(n) space
    public void countNodesInCompleteBinaryTree() {
        int count = countNodesHelper(this.root);
        System.out.println("The Total Number of Nodes are: " + count);
    }

    private int countNodesHelper(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            // We can apply the formula of full binary tree
            return (int) (Math.pow(2, leftHeight) - 1);
        }
        // count it recursively
        return countNodesHelper(root.left) + countNodesHelper(root.right) + 1;
    }

    private int getLeftHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return getLeftHeight(root.left) + 1;
    }

    private int getRightHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return getRightHeight(root.right) + 1;
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes tree = new CountCompleteTreeNodes();
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
        tree.countNodesInCompleteBinaryTree();
    }
}
