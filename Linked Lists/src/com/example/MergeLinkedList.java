package com.example;

public class MergeLinkedList {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public MergeLinkedList() {
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

    public void mergeLinkedList(Node headTwo) {
        Node p1 = head;
        Node p2 = headTwo;
        Node prev = null;
        while (p1 != null && p2 != null) {
            if (p2.value < p1.value) {
                if (prev != null) {
                    prev.next = p2;
                }
                prev = p2;
                p2 = p2.next;
                prev.next = p1;
            } else {
                prev = p1;
                p1 = p1.next;
            }
        }
        if (p1 == null) {
            prev.next = p2;
        }

        if (head.value > headTwo.value) {
            head = headTwo;
        }
    }

    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        list1.insertion(2);
        list1.insertion(6);
        list1.insertion(7);
        list1.insertion(8);
        System.out.println("The Linked List 1 is consist of : ");
        list1.traversal();
        MergeLinkedList list2 = new MergeLinkedList();
        list2.insertion(1);
        list2.insertion(3);
        list2.insertion(4);
        list2.insertion(5);
        list2.insertion(9);
        list2.insertion(10);
        System.out.println("The Linked List 2 is consist of : ");
        list2.traversal();
        list1.mergeLinkedList(list2.head);
        System.out.println("After merging linked list 1 with linked list 2 we get : ");
        list1.traversal();
    }
}
