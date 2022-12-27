package com.example;

public class DeleteNodeInLinkedList {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public DeleteNodeInLinkedList() {
        this.head = null;
    }

    public void insertion(int newValue) {
        Node newNode = new Node(newValue);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void traversal() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public Node getNode(int value) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    // O(1) time and O(1) space
    public void deleteNode(Node node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNodeInLinkedList list = new DeleteNodeInLinkedList();
        list.insertion(4);
        list.insertion(5);
        list.insertion(1);
        list.insertion(9);
        list.traversal();
        Node node = list.getNode(5);
        System.out.println("After Deletion of : " + node.value);
        list.deleteNode(node);
        list.traversal();
    }
}
