package com.example;

public class MergeTwoBinaryTrees {

    private Node root1;
    private Node root2;
    private Node root3;

    public MergeTwoBinaryTrees() {
        root1 = null;
        root2 = null;
        root3 = null;
    }

    public void traversal() {
        inOrderTraversal(root1);
        System.out.println("NULL");
        inOrderTraversal(root2);
        System.out.println("NULL");
        inOrderTraversal(root3);
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

    public void mergeTwoBinaryTree() {
        this.root3 = mergeTwoBinaryTreeHelper(this.root1, this.root2);
    }

    // O(m + n) time and O(m + n) space
    private Node mergeTwoBinaryTreeHelper(Node root1, Node root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Node newNode = new Node(root1.data + root2.data);
        newNode.left = mergeTwoBinaryTreeHelper(root1.left, root2.left);
        newNode.right = mergeTwoBinaryTreeHelper(root1.right, root2.right);

        return newNode;
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees tree = new MergeTwoBinaryTrees();
        tree.root1 = new Node(1);
        tree.root1.left = new Node(3);
        tree.root1.right = new Node(2);
        tree.root1.left.left = new Node(5);

        tree.root2 = new Node(2);
        tree.root2.left = new Node(1);
        tree.root2.right = new Node(3);
        tree.root2.left.right = new Node(4);
        tree.root2.right.right = new Node(7);
        tree.traversal();
        tree.mergeTwoBinaryTree();
        tree.traversal();
    }
}
