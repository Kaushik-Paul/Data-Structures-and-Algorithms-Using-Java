package com.example;

public class ConvertArrayToBst {

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

    public ConvertArrayToBst() {
        this.root = null;
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
        System.out.print(root.value + " -> ");
        inOrderTraversal(root.right);
    }

    public void convertArrayToBst(int[] array) {
        this.root = convertArrayToBstHelper(array, 0, array.length - 1);
    }

    // O(n) time and O(n) space
    private Node convertArrayToBstHelper(int[] array, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        Node newNode = new Node(array[middle]);
        newNode.left = convertArrayToBstHelper(array, left, middle - 1);
        newNode.right = convertArrayToBstHelper(array, middle + 1, right);
        return newNode;
    }

    public static void main(String[] args) {
        ConvertArrayToBst tree = new ConvertArrayToBst();
        int[] array = new int[]{-10, -3, 0, 5, 9};
        tree.convertArrayToBst(array);
        tree.traversal();
    }
}
