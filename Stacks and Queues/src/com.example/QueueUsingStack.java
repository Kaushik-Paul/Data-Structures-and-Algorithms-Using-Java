package com.example;

public class QueueUsingStack {

    private StackImplementation stack1;
    private StackImplementation stack2;

    public QueueUsingStack() {
        this.stack1 = new StackImplementation();
        this.stack2 = new StackImplementation();
    }

    // Here we will make the deQueue O(n) costly and enQueue simple O(1)
    public void enqueue(int newValue) {
        stack1.push(newValue);
    }

    public int deQueue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("The Queue is Empty !!! ");
            return Integer.MAX_VALUE;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int tempValue = stack1.pop();
                stack2.push(tempValue);
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int tempValue = stack1.pop();
                stack2.push(tempValue);
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enqueue(10);
        queueUsingStack.enqueue(20);
        queueUsingStack.enqueue(30);
        queueUsingStack.enqueue(40);
        queueUsingStack.enqueue(50);
        System.out.println("The Peek Value is: " + queueUsingStack.peek());
        System.out.println("The Dequeued Value is: " + queueUsingStack.deQueue());
        System.out.println("The Dequeued Value is: " + queueUsingStack.deQueue());
        System.out.println("The Peek Value is: " + queueUsingStack.peek());
    }
}
