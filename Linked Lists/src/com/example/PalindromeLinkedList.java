package com.example;

public class PalindromeLinkedList {

    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public PalindromeLinkedList() {
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

    // O(n) time and O(1) space
    public boolean isLinkedListPalindrome() {
        Node slowPointer = head;
        Node fastPointer = head;
        // Find the middle pointer
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        // Reverse the second half of linked list
        Node prev = null;
        while (slowPointer != null) {
            Node next = slowPointer.next;
            slowPointer.next = prev;
            prev = slowPointer;
            slowPointer = next;
        }

        // Compare the two linked list
        Node left = head;
        Node right = prev;
        while (left != null && right != null) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList linkedList = new PalindromeLinkedList();
        linkedList.insertion(1);
        linkedList.insertion(2);
        linkedList.insertion(2);
        linkedList.insertion(1);
        System.out.println("Is the linked list Palindrome: " + linkedList.isLinkedListPalindrome());
    }
}
