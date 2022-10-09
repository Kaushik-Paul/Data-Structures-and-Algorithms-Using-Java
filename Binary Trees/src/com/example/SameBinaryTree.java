package com.example;

public class SameBinaryTree {

    private Node root1;
    private Node root2;

    public SameBinaryTree() {
        root1 = null;
        root2 = null;
    }

    public void traversal() {
        inOrderTraversal(root1);
        System.out.println("NULL");
        inOrderTraversal(root2);
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

    public void sameBST() {
        System.out.println("Is Both the BST same: " + sameBSTHelper(this.root1, this.root2));
    }

    // O(n + m) time and O(n + m) space
    private boolean sameBSTHelper(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        return sameBSTHelper(root1.left, root2.left) && sameBSTHelper(root1.right, root2.right);
    }

    public static void main(String[] args) {
        SameBinaryTree tree = new SameBinaryTree();
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        tree.root1.right.left = new Node(6);
        tree.root1.right.right = new Node(7);
        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);
        tree.root2.right.left = new Node(6);
        tree.root2.right.right = new Node(7);
        tree.traversal();
        tree.sameBST();
    }
}
