package com.example;

public class KthSmallestElementInBst {
    private Node root;

    public KthSmallestElementInBst() {
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

    // O(n) time and O(n) space
    public void kthSmallestElement(int k) {
        int[] nums = new int[2];
        kthSmallestElementHelper(this.root, nums, k - 1);
        System.out.println("Value of Kth Smallest Element is: " + nums[1]);
    }

    private void kthSmallestElementHelper(Node root, int[] nums, int k) {
        if (root == null) {
            return;
        }
        kthSmallestElementHelper(root.left, nums, k);
        if (nums[0]++ == k) {
            nums[1] = root.data;
            return;
        }
        kthSmallestElementHelper(root.right, nums, k);
    }

    public static void main(String[] args) {
        KthSmallestElementInBst tree = new KthSmallestElementInBst();
        tree.insertion(5);
        tree.insertion(3);
        tree.insertion(6);
        tree.insertion(2);
        tree.insertion(4);
        tree.insertion(1);
        tree.traversal();
        tree.kthSmallestElement(3);
    }
}
