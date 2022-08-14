package com.example;

import java.util.Stack;

public class BasicCalculatorII {

    public static int basicCalculator(String string) {

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int num = 0;
        // To handle the first number
        char operator = '+';

        // To handle the last number
        for (char ch : (string + "+").toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                switch (operator) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        return -1;
                }
                operator = ch;
                num = 0;
            }
        }
        // Sum up all the value in stack to get the result
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        String string = "3 + 5 / 2";
        System.out.println("The Solution of the question is: " + basicCalculator(string));
    }
}
