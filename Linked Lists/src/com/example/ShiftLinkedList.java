package com.example;

public class ShiftLinkedList {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ShiftLinkedList() {
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

    public void shiftLinkedList(int k) {
        int length = 1;
        Node listTail = head;
        while (listTail.next != null) {
            listTail = listTail.next;
            length++;
        }

        int offset = Math.abs(k) % length;
        int newTailPosition = k > 0 ? length - offset : offset;
        Node newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }
        listTail.next = head;
        head = newTail.next;
        newTail.next = null;
    }

    public static void main(String[] args) {
        ShiftLinkedList list = new ShiftLinkedList();
        list.insertion(0);
        list.insertion(1);
        list.insertion(2);
        list.insertion(3);
        list.insertion(4);
        list.insertion(5);
        System.out.println("Before Shifting the linked List : ");
        list.traversal();
        int k = 2;
        list.shiftLinkedList(k);
        System.out.println("After shifting the linked list by " + k + " positions : ");
        list.traversal();
    }
}
