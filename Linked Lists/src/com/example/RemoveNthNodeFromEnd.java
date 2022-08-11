package com.example;

public class RemoveNthNodeFromEnd {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public RemoveNthNodeFromEnd() {
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

    public void removeNodeFromEnd(int N) {
        if (head == null) {
            return;
        }
        Node first = head;
        Node second = head;
        int counter = 1;
        while (second != null && counter <= N) {
            second = second.next;
            counter++;
        }
        if (second == null) {
            head = head.next;
            return;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd lst = new RemoveNthNodeFromEnd();
        lst.insertion(10);
        lst.insertion(20);
        lst.insertion(30);
        lst.insertion(40);
        lst.insertion(50);
        lst.insertion(60);
        lst.insertion(70);
        lst.insertion(80);
        lst.insertion(90);
        lst.insertion(100);
        lst.traversal();
        lst.removeNodeFromEnd(4);
        lst.traversal();
        lst.removeNodeFromEnd(9);
        lst.traversal();
    }
}
