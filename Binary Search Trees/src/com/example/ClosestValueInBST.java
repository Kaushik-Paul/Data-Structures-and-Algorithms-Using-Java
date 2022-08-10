package com.example;

public class ClosestValueInBST {

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

    public ClosestValueInBST() {
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

    public void closestValue(int target) {
        int value = findClosestValue(this.root, target, Integer.MAX_VALUE);
        System.out.println("The Value closest is: " + value);
        System.out.println("The Iterative Value closest is: " + findClosestValueIterative(target));
    }

    private int findClosestValue(Node root, int target, int closest) {
        if (root == null) {
            return closest;
        }
        if (Math.abs(root.value - target) < Math.abs(target - closest)) {
            closest = root.value;
        }
        if (root.value < target) {
            return findClosestValue(root.right, target, closest);
        } else if (root.value > target) {
            return findClosestValue(root.left, target, closest);
        } else {
            return closest;
        }
    }

    public int findClosestValueIterative(int target) {
        Node root = this.root;
        int closest = Integer.MAX_VALUE;
        while (root != null) {
            if (Math.abs(root.value - target) < Math.abs(target - closest)) {
                closest = root.value;
            }
            if (root.value < target) {
                root = root.right;
            } else if (root.value > target) {
                root = root.left;
            } else {
                return root.value;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        ClosestValueInBST bst = new ClosestValueInBST();
        bst.insertion(10);
        bst.insertion(5);
        bst.insertion(15);
        bst.insertion(2);
        bst.insertion(5);
        bst.insertion(1);
        bst.insertion(13);
        bst.insertion(22);
        bst.insertion(14);
        bst.closestValue(12);

    }

}
