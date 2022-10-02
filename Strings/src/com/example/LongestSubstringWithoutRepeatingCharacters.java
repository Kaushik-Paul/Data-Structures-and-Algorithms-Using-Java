package com.example;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    // O(n) time and O(min(n, a)) space  ** (a = length of hash map keys) **
    public static String longestSubstringWithoutRepeatingCharacters(String string) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        String longestSubstring = "";

        int startIdx = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (lastSeen.containsKey(ch)) {
                if (longestSubstring.length() < (i - startIdx)) {
                    longestSubstring = string.substring(startIdx, i);
                }
                startIdx = Math.max(startIdx, lastSeen.get(ch) + 1);
            }
            lastSeen.put(ch, i);
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        String string = "clementisacap";
        System.out.println("The Longest Substring Without Duplication is: " + longestSubstringWithoutRepeatingCharacters(string));
    }
}
