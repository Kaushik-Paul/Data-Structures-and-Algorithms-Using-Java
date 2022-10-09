package com.example;

public class ValidateBST {
    private Node root;

    public ValidateBST() {
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

    public void insertion(int newValue) {
       this.root = insertKey(this.root, newValue);
    }

    private Node insertKey(Node root, int newValue) {
        if (root == null) {
            return new Node(newValue);
        }
        if (root.data <= newValue) {
            root.right = insertKey(root.right, newValue);
        } else {
            root.left = insertKey(root.left, newValue);
        }
        return root;
    }

    public void validateBST() {
        if (validateBSTHelper(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("The Tree is a Valid BST");
        } else {
            System.out.println("The Tree is not a Valid BST");
        }
    }

    // O(n) time and O(n) space
    private boolean validateBSTHelper(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return validateBSTHelper(root.left, min, root.data) && validateBSTHelper(root.right, root.data, max);
    }

    public static void main(String[] args) {
        ValidateBST bst = new ValidateBST();
        bst.insertion(10);
        bst.insertion(5);
        bst.insertion(15);
        bst.insertion(2);
        bst.insertion(1);
        bst.insertion(13);
        bst.insertion(22);
        bst.insertion(14);
        bst.validateBST();
    }
}
