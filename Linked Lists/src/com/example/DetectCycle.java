package com.example;

public class DetectCycle {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public DetectCycle() {
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

    public boolean isCyclePresent() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycle loop = new DetectCycle();
        loop.insertion(0);
        loop.insertion(1);
        loop.insertion(2);
        loop.insertion(4);
        loop.insertion(5);
        loop.insertion(6);
        loop.insertion(7);
        loop.insertion(8);
        loop.insertion(9);

        // Trying to add loop in the linked list
        Node temp = loop.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node temp2 = loop.head;
        while (temp2.value != 4) {
            temp2 = temp2.next;
        }
        temp.next = temp2;
        // End of implementation

        System.out.println("Is Cycle Present: " + loop.isCyclePresent());
    }
}
