package com.example;

public class LowestCommonAncestorInBinaryTree {
    private Node root;

    public LowestCommonAncestorInBinaryTree() {
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

    // O(n) time and O(n) space
    public void lowestCommonAncestor(int p, int q) {
        Node node = lowestCommonAncestorHelper(this.root, p, q);
        System.out.println("The Lowest Common Ancestor is: " + node.data);
    }

    private Node lowestCommonAncestorHelper(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        Node left = lowestCommonAncestorHelper(root.left, p, q);
        Node right = lowestCommonAncestorHelper(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            // Found the result
            return root;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorInBinaryTree tree = new LowestCommonAncestorInBinaryTree();
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
        tree.lowestCommonAncestor(4, 10);
    }
}
