package com.example;

public class StringToInteger {

    // O(n) time and O(1) space
    public static int stringToInteger(String string) {
        int result = 0;
        boolean isNegative = false;
        for (char ch : string.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (ch == '-') {
                isNegative = true;
                continue;
            }
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                result = (result * 10) + num;
            } else {
                return result;
            }
        }
        return isNegative ? -1 * result : result;
    }

    public static void main(String[] args) {
        String string = "          -   123";
        System.out.println("The Integer of the string is: " + stringToInteger(string));
    }
}
