package com.example;

public class PopulatingNextRightPointers {
    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;
        Node next;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }

    public PopulatingNextRightPointers() {
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
        System.out.print(root.value+" -> ");
        inOrderTraversal(root.right);
    }

    public void nextOrderTraversal() {
        nextOrderTraversalHelper(this.root);
    }

    private void nextOrderTraversalHelper(Node root) {
        if (root == null) {
            return;
        }
        Node nextNode = root.left;
        while (root != null) {
            System.out.print(root.value + "-> ");
            root = root.next;
        }
        System.out.print("NULL -> ");
        if (nextNode != null) {
            nextOrderTraversalHelper(nextNode);
        }
    }

    public void addLinkToNextPointers() {
        this.root = addLinkToNextPointersHelper(this.root);
    }

    // O(n) time and O(1) space
    private Node addLinkToNextPointersHelper(Node root) {
        if (root == null || root.left == null) {
            return null;
        }
        Node current = root;
        Node next = current.left;
        while (next != null) {
            current.left.next = current.right;
            if (current.next != null) {
                current.right.next = current.next.left;
            }
            current = current.next;
            if (current == null) {
                current = next;
                next = current.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointers tree = new PopulatingNextRightPointers();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
//        tree.traversal();
        tree.addLinkToNextPointers();
        tree.nextOrderTraversal();
    }
}
