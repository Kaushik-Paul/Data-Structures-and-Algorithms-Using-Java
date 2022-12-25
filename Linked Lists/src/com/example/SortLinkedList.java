package com.example;

public class SortLinkedList {
    private Node head;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public SortLinkedList() {
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

    // O(nlog n) time and O(1) space
    public void sortLinkedList() {
        this.head = sort(this.head);
    }

    private Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slowNode = head;
        Node fastNode = head;
        Node tempNode = head;
        // Dividing linked list into two halves
        while (fastNode != null && fastNode.next != null) {
            tempNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        tempNode.next = null;

        Node leftSide = sort(head);
        Node rightSide = sort(slowNode);
        return merge(leftSide, rightSide);
    }

    private Node merge(Node leftSide, Node rightSide) {
        if (leftSide == null || rightSide == null) {
            return null;
        }
        // Dummy Node
        Node sortedNode = new Node(0);
        Node currentNode = sortedNode;
        while (leftSide != null && rightSide != null) {
            if (leftSide.value <= rightSide.value) {
                currentNode.next = leftSide;
                leftSide = leftSide.next;
            } else {
                currentNode.next = rightSide;
                rightSide = rightSide.next;
            }
            currentNode = currentNode.next;
        }
        while (leftSide != null) {
            currentNode.next = leftSide;
            leftSide = leftSide.next;
        }
        while (rightSide != null) {
            currentNode.next = rightSide;
            rightSide = rightSide.next;
        }
        return sortedNode.next;
    }

    public static void main(String[] args) {
        SortLinkedList list = new SortLinkedList();
        list.insertion(-1);
        list.insertion(5);
        list.insertion(3);
        list.insertion(4);
        list.insertion(0);
        list.traversal();
        list.sortLinkedList();
        list.traversal();
    }
}
