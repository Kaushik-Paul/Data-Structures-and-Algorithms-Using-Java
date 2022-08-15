package com.example;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

    public static String longestSubstringWithoutDuplication(String string) {

        String longestSubstring = "";
        Map<Character, Integer> lastSeen = new HashMap<>();
        int startIdx = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (lastSeen.containsKey(ch)) {
                if (longestSubstring.length() < (i - startIdx)) {
                    longestSubstring = string.substring(startIdx, i);
                }
                startIdx = Math.max(lastSeen.get(ch) + 1, startIdx);
                lastSeen.replace(ch, i);
            } else {
                lastSeen.put(ch, i);
            }
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        String string = "clementisacap";
        System.out.println("The Longest Substring Without Duplication is: " + longestSubstringWithoutDuplication(string));
    }
}
