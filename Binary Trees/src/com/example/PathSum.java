package com.example;

public class PathSum {

    private Node root;

    public PathSum() {
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

    public void pathSum(int target) {
        if (pathSumHelper(this.root, target)) {
            System.out.println("It has a Path Sum");
        } else {
            System.out.println("It does not have a Path Sum");
        }
    }

    // O(n) time and O(n) space
    private boolean pathSumHelper(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.data == sum;
        }
        return pathSumHelper(root.left, sum - root.data) || pathSumHelper(root.right, sum - root.data);
    }

    public static void main(String[] args) {
        PathSum tree = new PathSum();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(11);
        tree.root.right.right = new Node(4);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(2);
        tree.root.right.left = new Node(13);
        tree.root.right.right.right = new Node(1);
        tree.traversal();
        int target = 22;
        tree.pathSum(target);
    }
}
