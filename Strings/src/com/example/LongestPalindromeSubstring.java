package com.example;

public class LongestPalindromeSubstring {

    public static String longestPalindromeSubstring(String string) {

        String  currentLongestSubstring = "";
        for (int i = 1; i < string.length(); i++) {
            String even = getLongestPalindromeSubstringFrom(string, i - 1, i);
            String odd = getLongestPalindromeSubstringFrom(string, i - 1, i + 1);
            int longest = Math.max(even.length(), odd.length());
            if (longest > currentLongestSubstring.length()) {
                if (longest == odd.length()) {
                    currentLongestSubstring = odd;
                } else {
                    currentLongestSubstring = even;
                }
            }
        }

        return currentLongestSubstring;
    }

    private static String getLongestPalindromeSubstringFrom(String string, int startIdx, int endIdx) {

        while (startIdx >= 0 && endIdx < string.length()) {
            if (string.charAt(startIdx) != string.charAt(endIdx)) {
                break;
            }
            startIdx--;
            endIdx++;
        }
        return string.substring(startIdx + 1, endIdx);
    }

    public static void main(String[] args) {
        String string = "abaxyzzyxf";
        System.out.println("The Longest Palindrome Substring of " + string + " is : " + longestPalindromeSubstring(string));
    }
}
