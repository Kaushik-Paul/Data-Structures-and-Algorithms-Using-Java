package com.example;

public class BSTConstruction {

    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BSTConstruction() {
        this.root = null;
    }

    public void insertion(int newValue) {
       this.root = insertKey(this.root, newValue);
    }

    private Node insertKey(Node root, int newValue) {
        if (root == null) {
            return new Node(newValue);
        }
        if (root.value <= newValue) {
            root.right = insertKey(root.right, newValue);
        } else {
            root.left = insertKey(root.left, newValue);
        }
        return root;
    }

    public void deletion(int deleteValue) {
        this.root = deleteKey(this.root, deleteValue);
    }

    private Node deleteKey(Node root, int deleteValue) {
        if (root == null) {
            return null;
        }
        if (root.value < deleteValue) {
            root.right = deleteKey(root.right, deleteValue);
        } else if (root.value > deleteValue) {
            root.left = deleteKey(root.left, deleteValue);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.value = findMinValue(root.right);
                root.right = deleteKey(root.right, root.value);
            }
        }
        return root;
    }

    private int findMinValue(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null) {
            return root.value;
        }
        return findMinValue(root.left);
    }

    public void search(int searchValue) {
        boolean isPresent = searchKey(this.root, searchValue);
        System.out.println("The Key is Present: " + isPresent);
    }

    private boolean searchKey(Node root, int searchValue) {
        if (root == null) {
            return false;
        }
        if (root.value == searchValue) {
            return true;
        }
        if (root.value <= searchValue) {
            return searchKey(root.right, searchValue);
        } else {
            return searchKey(root.left, searchValue);
        }
    }

    public void traversal() {
        inOrderTraversal(this.root);
        System.out.println("NULL");
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " --> ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        BSTConstruction bst = new BSTConstruction();
        bst.insertion(10);
        bst.insertion(5);
        bst.insertion(15);
        bst.insertion(2);
        bst.insertion(5);
        bst.insertion(1);
        bst.insertion(12);
        bst.insertion(13);
        bst.insertion(22);
        bst.insertion(14);
        bst.traversal();
        bst.search(23);
        bst.deletion(10);
        bst.traversal();
    }
}
