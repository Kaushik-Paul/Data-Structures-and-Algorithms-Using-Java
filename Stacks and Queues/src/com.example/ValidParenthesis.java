package com.example;

import java.util.*;

public class ValidParenthesis {

    // O(n) time and O(n) space
    public static boolean validParenthesis(String string) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        Set<Character> openingBrackets = Set.of('(', '{', '[');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (brackets.containsKey(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != brackets.get(ch)) {
                    return false;
                }
            } else {
                if (openingBrackets.contains(ch)) {
                    stack.push(ch);
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String string = "(([]()()){})";
        System.out.println("Is the parenthesis balanced: " + validParenthesis(string));
    }
}
