package com.example;

public class CheckValidParenthesisString {

    // Leet Code Qno - 678
    // O(n) time and O(1) space
    public static boolean checkValidParenthesisString(String string) {
        int leftMin = 0, leftMax = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '(') {
                leftMin++;
                leftMax++;
            } else if (ch == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }

    public static void main(String[] args) {
        String string = "(*))";
        System.out.println("Is it a valid parenthesis String: " + checkValidParenthesisString(string));
    }
}
