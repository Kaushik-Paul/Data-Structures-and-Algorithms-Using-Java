package com.example;

import java.util.Stack;

public class ReversePolishNotation {

    // O(n) time and O(n) space
    public static int reversePolishNotation(String[] expression) {
        Stack<Integer> stack = new Stack<>();
        for (String ch: expression) {
            switch (ch) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 / num1);
                }
                default -> stack.push(Integer.parseInt(ch));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] expression = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("The result after evaluation: " + reversePolishNotation(expression));
    }
}
