package com.example;

public class LongestCommonPrefix {

    // O(m * n) time and O(1) space
    public static String longestCommonPrefix(String[] strings) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strings[0].length(); i++) {
            char ch = strings[0].charAt(i);
            for (String string : strings) {
                if (i == string.length() || ch != string.charAt(i)) {
                    return result.toString();
                }
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight"};
        System.out.println("The Longest Common Prefix is: " + longestCommonPrefix(strings));
    }
}
