package com.example;

public class BinaryTreeFromPreorderInorder {
    private Node root;

    public BinaryTreeFromPreorderInorder() {
        root = null;
    }

    private void traversal() {
        inOrderTraversal(root);
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

    // O(n) time and O(n) space
    public void buildBinaryTree(int[] preOrder, int[] inOrder) {
        this.root = buildBinaryTreeHelper(0, 0, inOrder.length - 1, preOrder, inOrder);
        traversal();
    }

    private Node buildBinaryTreeHelper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if (inStart > inEnd || preStart >= preOrder.length) {
            return null;
        }
        Node node = new Node(preOrder[preStart]);

        // Find the index in the inorder array
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (node.data == inOrder[i]) {
                inIndex = i;
            }
        }
        node.left = buildBinaryTreeHelper(preStart + 1, inStart, inIndex - 1, preOrder, inOrder);
        node.right = buildBinaryTreeHelper(preStart + (inIndex - inStart + 1), inIndex + 1, inEnd, preOrder, inOrder);
        return node;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        BinaryTreeFromPreorderInorder tree = new BinaryTreeFromPreorderInorder();
        tree.buildBinaryTree(preOrder, inOrder);
    }
}
