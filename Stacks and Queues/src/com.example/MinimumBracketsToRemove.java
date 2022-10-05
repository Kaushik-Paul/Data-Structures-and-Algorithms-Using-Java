package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MinimumBracketsToRemove {

    // O(n) time and O(n) space
    public static String validString(String string) {
        List<Character> charList = new ArrayList<>();
        for (char ch : string.toCharArray()) {
            charList.add(ch);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')' && !stack.isEmpty()) {
                stack.pop();
            } else if (ch == ')') {
                charList.remove(i);
            }
        }
        while (!stack.isEmpty()) {
            charList.remove(stack.pop());
        }
        return charList.stream()
                .map(st -> String.valueOf(st))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String string = "))((";
        System.out.println("Valid String after removing Brackets: " + validString(string));
    }
}
