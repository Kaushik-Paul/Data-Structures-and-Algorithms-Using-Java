package com.example;

public class AlmostPalindrome {

    // O(n) time and O(1) space
    public static boolean isAlmostPalindrome(String string) {
        int startIdx = 0, endIdx = string.length() - 1;
        while (startIdx < endIdx) {
            if (string.charAt(startIdx) != string.charAt(endIdx)) {
                return checkSubstringPalindrome(string, startIdx + 1, endIdx) || checkSubstringPalindrome(string, startIdx, endIdx - 1);
            }
            startIdx++;
            endIdx--;
        }
        return true;
    }

    private static boolean checkSubstringPalindrome(String string, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            if (string.charAt(startIdx) != string.charAt(endIdx)) {
                return false;
            }
            startIdx++;
            endIdx--;
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "abca";
        System.out.println("Is the String Almost Palindrome: " + isAlmostPalindrome(string));
    }
}
