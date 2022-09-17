package com.example;

public class LongestPalindromicSubstring {

    // O(n^2) time and O(n) space
    public static String getLongestPalindromicSubstring(String string) {
        String longestPalindromicSubstring = "";
        int longestLength = Integer.MIN_VALUE;

        for (int i = 0; i < string.length(); i++) {
            // check for oddValue
            String odd = getPalindromicSubstring(string, i, i);
            String even = getPalindromicSubstring(string, i, i + 1);
            int max = Math.max(odd.length(), even.length());
            if (max > longestLength) {
                longestLength = max;
                if (longestLength == odd.length()) {
                    longestPalindromicSubstring = odd;
                } else {
                    longestPalindromicSubstring = even;
                }
            }
        }
        return longestPalindromicSubstring;
    }

    private static String getPalindromicSubstring(String string, int startIdx, int endIdx) {
        while (startIdx >= 0 && endIdx < string.length() && string.charAt(startIdx) == string.charAt(endIdx)) {
            startIdx--;
            endIdx++;
        }
        // startIdx is reduced in the loop
        return string.substring(startIdx + 1, endIdx);
    }

    public static void main(String[] args) {
        String string = "abaxyzzyxf";
        System.out.println("The Longest Palindrome Substring of " + string + " is : " + getLongestPalindromicSubstring(string));
    }
}
