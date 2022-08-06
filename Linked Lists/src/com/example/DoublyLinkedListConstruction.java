package com.example;

public class DoublyLinkedListConstruction {

    private Node head;
    private Node tail;

    private static class Node {
        int value;
        Node previous;
        Node next;

        public Node(int value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }

    }

    public DoublyLinkedListConstruction() {
        this.head = null;
        this.tail = null;
    }

    public void traversal() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public Node insertion(int newValue) {
        Node newNode = new Node(newValue);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return newNode;
        }
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        return newNode;
    }

    public Node deletion() {
        if (tail == null) {
            System.out.println("The List is Empty !!!");
            return null;
        }
        if (head == tail) {
            Node tempNode = tail;
            head = null;
            tail = null;
            return tempNode;
        }
        Node tempNode = tail;
        tail = tail.previous;
        tail.next = null;
        return tempNode;
    }



    public static void main(String[] args) {
        DoublyLinkedListConstruction lst = new DoublyLinkedListConstruction();
        lst.insertion(10);
        lst.insertion(20);
        lst.insertion(30);
        lst.insertion(40);
        lst.insertion(50);
        lst.traversal();
        Node deletedNode = lst.deletion();
        System.out.println("The Value which is deleted is: " + deletedNode.value);
        lst.traversal();
    }
    
}
