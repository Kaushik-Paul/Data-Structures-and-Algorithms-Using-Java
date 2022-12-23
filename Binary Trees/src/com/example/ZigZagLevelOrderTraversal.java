package com.example;

import java.util.*;

public class ZigZagLevelOrderTraversal {
    private Node root;

    public ZigZagLevelOrderTraversal() {
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

    public void zigZagLevelOrderBinaryTree() {
        List<int[]> list = zigZagLevelOrderBinaryTreeHelper(this.root);
        System.out.print("The Zig Zag Level Order for the Binary Tree is: ");
        list.forEach(num -> System.out.print(Arrays.toString(num) + ", "));
    }

    // O(n) time and O(n) space
    private List<int[]> zigZagLevelOrderBinaryTreeHelper(Node root) {
         List<int[]> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int[] level = new int[queueSize];
            for (int i = 0; i < queueSize; i++) {
                Node currentNode = queue.poll();
                int index = leftToRight ? i : queueSize - 1 - i;
                level[index] = currentNode.data;
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversal tree = new ZigZagLevelOrderTraversal();
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
        tree.zigZagLevelOrderBinaryTree();
    }
}
