package com.example;

import java.util.Arrays;

public class ReverseString {

    public String reverseString(String string) {
        if (string.length() <= 1) {
            return string;
        }
        return reverseString(string.substring(1)) + string.charAt(0);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String string = "Hello how are you";
        System.out.println("The Reversed String is: " + reverseString.reverseString(string));
    }
}
