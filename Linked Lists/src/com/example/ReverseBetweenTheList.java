package com.example;

public class ReverseBetweenTheList {

    private Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ReverseBetweenTheList() {
        this.head = null;
    }

    // Index in parameters start from 1
    // O(n) time and O(1) space
    public void reverseBetweenTheList(int startIdx, int endIdx) {
        Node currentNode = head;
        Node start = head;
        int currentPosition = 1;

        while (currentPosition < startIdx) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPosition++;
        }

        Node newTail = currentNode;
        Node previous = null;

        while (currentPosition >= startIdx && currentPosition <= endIdx) {
            // steps similar to reversing the linked list
            Node next = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = next;
            currentPosition++;
        }

        start.next = previous;
        newTail.next = currentNode;

        if (startIdx == 1) {
            this.head = previous;
        }
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

    public static void main(String[] args) {
        ReverseBetweenTheList lst = new ReverseBetweenTheList();
        lst.insertion(10);
        lst.insertion(20);
        lst.insertion(30);
        lst.insertion(40);
        lst.insertion(50);
        lst.traversal();
        lst.reverseBetweenTheList(2, 4);
        lst.traversal();
    }
}
