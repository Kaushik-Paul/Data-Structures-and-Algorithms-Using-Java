package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBinaryTree {

    private Node root;

    public LevelOrderBinaryTree() {
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

    public void levelOrderBinaryTree() {
        List<List<Integer>> list = levelOrderBinaryTreeHelper(this.root);
        System.out.println("The Level Order for the Binary Tree is: " + list);

    }

    // O(n) time and O(n) space
    private List<List<Integer>> levelOrderBinaryTreeHelper(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node currentNode = queue.poll();
                level.add(currentNode.data);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrderBinaryTree tree = new LevelOrderBinaryTree();
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
        tree.levelOrderBinaryTree();
    }
}
