package com.example;

public class QueueImplementation {

    private Node head;
    private Node tail;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public QueueImplementation() {
        this.head = null;
        this.tail = null;
    }

    public void enQueue(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null && tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public int deQueue() {
        if (head == null) {
            System.out.println("The Queue is Empty !!!");
            return Integer.MAX_VALUE;
        }

        int deQueuedValue = head.value;
        head = head.next;
        return deQueuedValue;
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
        QueueImplementation queue = new QueueImplementation();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        queue.traversal();
        System.out.println("The Dequeued Value is: " + queue.deQueue());
        queue.traversal();
        System.out.println("The Dequeued Value is: " + queue.deQueue());
        queue.traversal();
    }
}
