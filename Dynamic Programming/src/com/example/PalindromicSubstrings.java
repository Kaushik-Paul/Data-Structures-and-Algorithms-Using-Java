package com.example;

public class PalindromicSubstrings {

    // O(n^2) time and O(1) space
    public static int getTotalPalindromicSubstringsCount(String string) {
        int totalCount = 0;
        for (int i = 0; i < string.length(); i++) {
            // For Odd Palindrome
            totalCount += getPalindromeCount(string, i, i);
            // For Even Palindrome
            totalCount += getPalindromeCount(string, i, i + 1);
        }
        return totalCount;
    }

    private static int getPalindromeCount(String string, int startIdx, int endIdx) {
        int count = 0;
        while (startIdx >= 0 && endIdx < string.length() && string.charAt(startIdx) == string.charAt(endIdx)) {
            startIdx--;
            endIdx++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String string = "aaab";
        System.out.println("The total number of Palindromic Substring is: " + getTotalPalindromicSubstringsCount(string));
    }
}
