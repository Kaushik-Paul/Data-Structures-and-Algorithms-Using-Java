package com.example;

public class AddTwoNumbers {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public AddTwoNumbers() {
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

    // O(n) time and O(n) space
    public void addTwoNumbers(Node head1, Node head2) {
        Node newHead = new Node(0);
        Node newLinkedList = newHead;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int value1 = head1 != null ? head1.value : 0;
            int value2 = head2 != null ? head2.value : 0;
            int addNumber = value1 + value2 + carry;
            int lastDigit = addNumber % 10;
            carry = addNumber / 10;
            Node newNode = new Node(lastDigit);
            newLinkedList.next = newNode;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
            newLinkedList = newLinkedList.next;
        }

        // Any Extra Carry
        if (carry != 0) {
            newLinkedList.next = new Node(carry);
        }
        this.head = newHead.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers list1 = new AddTwoNumbers();
        list1.insertion(2);
        list1.insertion(4);
        list1.insertion(3);
        AddTwoNumbers list2 = new AddTwoNumbers();
        list2.insertion(5);
        list2.insertion(6);
        list2.insertion(4);
        AddTwoNumbers list3 = new AddTwoNumbers();
        list3.addTwoNumbers(list1.head, list2.head);
        list3.traversal();
    }
}
