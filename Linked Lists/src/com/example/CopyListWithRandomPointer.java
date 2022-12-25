package com.example;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    private Node head;

    private static class Node {
        int value;
        Node next;
        Node random;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.random = null;
        }
    }

    public CopyListWithRandomPointer() {
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

    public void addLink(int position, int linkPosition) {
        int length = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        currentNode = this.head;
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.next;
        }
        if (linkPosition > length) {
            currentNode.random = null;
            return;
        }

        Node linkNode = this.head;
        for (int i = 1; i < linkPosition; i++) {
            linkNode = linkNode.next;
        }
        currentNode.random = linkNode;
    }

    public void traversal() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // O(n) time and O(n) space
    public void copyList(Node oldRoot) {
        this.head = copyListHelper(oldRoot);
    }

    private Node copyListHelper(Node oldRoot) {
        if (oldRoot == null) {
            return null;
        }
        // Link old node with new node
        Map<Node, Node> oldToCopy = new HashMap<>();

        Node currentNode = oldRoot;
        while (currentNode != null) {
            Node newNode = new Node(currentNode.value);
            oldToCopy.put(currentNode, newNode);
            currentNode = currentNode.next;
        }
        // Link the new node created
        currentNode = oldRoot;
        while (currentNode != null) {
            Node node = oldToCopy.get(currentNode);
            node.next = oldToCopy.get(currentNode.next);
            node.random = oldToCopy.get(currentNode.random);
            currentNode = currentNode.next;
        }

        return oldToCopy.get(oldRoot);
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer list = new CopyListWithRandomPointer();
        list.insertion(7);
        list.insertion(13);
        list.insertion(11);
        list.insertion(10);
        list.insertion(1);
        list.addLink(1, 6);
        list.addLink(2, 1);
        list.addLink(3, 3);
        list.addLink(4, 1);
        list.addLink(5, 1);
        CopyListWithRandomPointer list2 = new CopyListWithRandomPointer();
        list2.copyList(list.head);
        list2.traversal();
    }
}
