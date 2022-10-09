package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    private Node root;

    public BinaryTreeRightSideView() {
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

    public void rightSideViewElements() {
        List<Integer> list = rightSideViewElementsHelper(this.root);
        System.out.println("The Right Side Elements in the Binary Tree is: " + list);
    }

    // O(nlog n) time and O(n) space
    private List<Integer> rightSideViewElementsHelper(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                Node currentNode = queue.poll();
                if (i == 0) {
                    result.add(currentNode.data);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
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
        tree.rightSideViewElements();
    }
}
