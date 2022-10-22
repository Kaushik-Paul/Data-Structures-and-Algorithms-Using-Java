package com.example;

public class IntersectionOfTwoLinkedList {

    private Node head1;
    private Node head2;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public IntersectionOfTwoLinkedList() {
        this.head1 = null;
        this.head2 = null;
    }

    public void insertionHead1(int newValue) {
        Node newNode = new Node(newValue);
        if (head1 == null) {
            head1 = newNode;
            return;
        }
        Node temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertionHead2(int newValue) {
        Node newNode = new Node(newValue);
        if (head2 == null) {
            head2 = newNode;
            return;
        }
        Node temp = head2;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // O(n + m) time and O(1) space
    public int findIntersectionOfLinkedList() {
        int lengthHead1 = 0;
        int lengthHead2 = 0;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null) {
            lengthHead1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            lengthHead2++;
            temp2 = temp2.next;
        }
        temp1 = head1;
        temp2 = head2;
        if (lengthHead1 > lengthHead2) {
            int diff = lengthHead1 - lengthHead2;
            while (diff != 0) {
                temp1 = temp1.next;
                diff--;
            }
        } else {
            int diff = lengthHead2 - lengthHead1;
            while (diff != 0) {
                temp2 = temp2.next;
                diff--;
            }
        }

        while (temp1 != null && temp2 != null && temp1.value != temp2.value) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return (temp1 == null || temp2 == null) ? 0 : temp1.value;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedList linkedList = new IntersectionOfTwoLinkedList();
        linkedList.insertionHead1(4);
        linkedList.insertionHead1(1);
        linkedList.insertionHead1(8);
        linkedList.insertionHead1(4);
        linkedList.insertionHead1(5);

        linkedList.insertionHead2(5);
        linkedList.insertionHead2(6);
        linkedList.insertionHead2(1);
        linkedList.insertionHead2(8);
        linkedList.insertionHead2(5);
        linkedList.insertionHead2(4);
        System.out.println("The Intersection Point is: " + linkedList.findIntersectionOfLinkedList());
    }
}
