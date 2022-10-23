package com.example;

public class PathSum3 {

    private Node root;

    public PathSum3() {
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

    public void numberOfPath(int sum) {
        System.out.println("The Number of ways to get the path sum: " + findPathSum(this.root, sum));
    }

    private int findPathSum(Node root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPathSum(root.left, sum) + findPathSumFrom(root, sum) + findPathSum(root.right, sum);
    }

    // O(nlog n) time and O(nlog n) space
    private int findPathSumFrom(Node root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.data == sum) {
            res++;
        }
        res += findPathSum(root.left, sum - root.data);
        res += findPathSum(root.right, sum - root.data);
        return res;
    }

    public static void main(String[] args) {
        PathSum3 tree = new PathSum3();
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(-3);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(2);
        tree.root.right.right = new Node(11);
        tree.root.left.left.left = new Node(3);
        tree.root.left.left.right = new Node(-2);
        tree.root.left.right.right = new Node(1);
        tree.traversal();
        tree.numberOfPath(8);
    }
}
