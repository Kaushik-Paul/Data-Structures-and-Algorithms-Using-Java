package com.example;

import java.util.Stack;

// O(n) space
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minValueStack;

    public MinStack() {
        stack = new Stack<>();
        minValueStack = new Stack<>();
    }

    // O(1) time
    public void push(int value) {
        stack.push(value);
        if (minValueStack.isEmpty() || value <= minValueStack.peek()) {
            minValueStack.push(value);
        }
    }

    // O(1) time
    public void pop() {
        int value = stack.pop();
        if (value == minValueStack.peek()) {
            minValueStack.pop();
        }
    }

    // O(1) time
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return Integer.MAX_VALUE;
    }

    // O(1) time
    public int getMin() {
        if (!minValueStack.isEmpty()) {
            return minValueStack.peek();
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println("Get Min : " + stack.getMin());
        stack.pop();
        System.out.println("Top Element: " + stack.top());
        System.out.println("Get Min : " + stack.getMin());
    }
}
