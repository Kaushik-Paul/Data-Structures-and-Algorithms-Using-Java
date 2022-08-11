package com.example;

public class FindLoop {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public FindLoop() {
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

    public void findLoop() {
        Node node = findLoopNode();
        if (node == null) {
            System.out.println("There is no loop in the linked list");
        } else {
            System.out.println("The loop in the linked list start from: " + node.value);
        }
    }

    private Node findLoopNode() {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node first = head.next;
        Node second = head.next.next;
        while (first != second) {
            first = first.next;
            second = second.next.next;
        }
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public static void main(String[] args) {
        FindLoop loop = new FindLoop();
        loop.insertion(0);
        loop.insertion(1);
        loop.insertion(2);
        loop.insertion(4);
        loop.insertion(5);
        loop.insertion(6);
        loop.insertion(7);
        loop.insertion(8);
        loop.insertion(9);

        // Trying to add loop in the linked list
        Node temp = loop.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node temp2 = loop.head;
        while (temp2.value != 4) {
            temp2 = temp2.next;
        }
        temp.next = temp2;
        // End of implementation

        loop.findLoop();
    }
}
