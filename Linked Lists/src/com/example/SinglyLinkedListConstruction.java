package com.example;

public class SinglyLinkedListConstruction {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public SinglyLinkedListConstruction() {
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

    public void deletion() {
        Node temp = head;
        Node prev = temp;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp = null;
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
        SinglyLinkedListConstruction lst = new SinglyLinkedListConstruction();
        lst.insertion(10);
        lst.insertion(20);
        lst.insertion(30);
        lst.insertion(40);
        lst.insertion(50);
        lst.traversal();
        lst.deletion();
        lst.traversal();
    }
}
