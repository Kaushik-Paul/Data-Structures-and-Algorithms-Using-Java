package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalancedBrackets(String string) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        Set<Character> openingBracket = Set.of('(', '{', '[');

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
                if (openingBracket.contains(ch)) {
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
        System.out.println("Is it a balanced bracket?: " + isBalancedBrackets(string));
    }
}
