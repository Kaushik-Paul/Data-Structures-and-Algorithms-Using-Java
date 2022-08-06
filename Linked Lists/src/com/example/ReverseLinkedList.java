package com.example;

public class ReverseLinkedList {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ReverseLinkedList() {
        this.head = null;
    }

    public void reverseLinkedList() {
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
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
        ReverseLinkedList lst = new ReverseLinkedList();
        lst.insertion(10);
        lst.insertion(20);
        lst.insertion(30);
        lst.insertion(40);
        lst.insertion(50);
        lst.traversal();
        lst.reverseLinkedList();
        lst.traversal();
    }
}
