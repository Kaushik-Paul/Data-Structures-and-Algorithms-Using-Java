package com.example;

public class SymmetricTree {

    private Node root1;

    public SymmetricTree() {
        root1 = null;
    }

    public void traversal() {
        inOrderTraversal(root1);
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

    public void isSymmetricTree() {
        System.out.println("Is both the tree Symmetric: " + symmetricTreeHelper(root1.left, root1.right));
    }

    // O(n + m) time and O(n + m) space
    private boolean symmetricTreeHelper(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        return symmetricTreeHelper(root1.left, root2.right) && symmetricTreeHelper(root1.right, root2.left);
    }

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(2);
        tree.root1.left.left = new Node(3);
        tree.root1.left.right = new Node(4);
        tree.root1.right.left = new Node(4);
        tree.root1.right.right = new Node(3);
        tree.traversal();
        tree.isSymmetricTree();
    }
}
