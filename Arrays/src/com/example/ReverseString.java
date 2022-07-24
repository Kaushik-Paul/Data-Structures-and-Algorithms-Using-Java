package com.example;

public class ReverseString {

    public static String reverseStringMethodOne(String string) {
        char[] reverseString = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            reverseString[i] = string.charAt(string.length() - i - 1);
        }
        return new String(reverseString);
    }

    public static String reverseStringMethodTwo(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String string = "Hi My name is Andrei";
        System.out.format("Original String is %s\n", string);
        System.out.println("Reversed String method one is: " + reverseStringMethodOne(string));
        System.out.println("Reversed String method two is: " + reverseStringMethodTwo(string));

    }
}
