package com.example;

public class StackImplementation {

    private Node top;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public StackImplementation() {
        this.top = null;
    }

    public void push(int newValue) {
        Node newNode = new Node(newValue);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }


    public int pop() {
        if (top == null) {
            System.out.println("The Stack is Empty !!!");
            return Integer.MAX_VALUE;
        }
        int popValue = top.value;
        top = top.next;
        return popValue;
    }

    public int peek() {
        if (top == null) {
            System.out.println("The Stack is Empty !!!");
            return Integer.MAX_VALUE;
        }
        return top.value;
    }

    public void traversal() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.traversal();
        System.out.println("The Peek Value is: " + stack.peek());
        stack.pop();
        stack.traversal();
        System.out.println("The Peek Value is: " + stack.peek());
    }
}
