package com.example;

public class OddEvenLinkedList {
    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public OddEvenLinkedList() {
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

    // O(n) time and O(1) space
    public void reconstructToOddEvenList() {
        Node odd = this.head;
        Node even = this.head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }

    public static void main(String[] args) {
        OddEvenLinkedList list = new OddEvenLinkedList();
        list.insertion(2);
        list.insertion(1);
        list.insertion(3);
        list.insertion(5);
        list.insertion(6);
        list.insertion(4);
        list.insertion(8);
        list.traversal();
        list.reconstructToOddEvenList();
        list.traversal();
    }
}
