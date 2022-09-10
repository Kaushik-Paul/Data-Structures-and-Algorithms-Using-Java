package com.example;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int longestSubstringLength(String string) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int right = 0; right < string.length(); right++) {
            while (set.contains(string.charAt(right))) {
                set.remove(string.charAt(left));
                left++;
            }
            set.add(string.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String string = "abcabcbb";
        System.out.println("The Longest Substring is: " + longestSubstringLength(string));
    }
}
