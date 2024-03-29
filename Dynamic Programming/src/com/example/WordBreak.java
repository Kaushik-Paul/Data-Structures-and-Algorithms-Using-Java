package com.example;

import java.util.Arrays;

public class WordBreak {

    // O(n) time and O(n) space
    public static boolean wordBreak(String string, String[] wordDict) {
        // One extra element for base case
        boolean[] checkWordBreak = new boolean[string.length() + 1];
        Arrays.fill(checkWordBreak, false);
        checkWordBreak[string.length()] = true;

        for (int i = string.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (word.length() + i <= string.length() && string.substring(i, i + word.length()).equals(word)) {
                    checkWordBreak[i] = checkWordBreak[i + word.length()];
                }
                if (checkWordBreak[i]) {
                    break;
                }
            }
        }
        return checkWordBreak[0];
    }

    public static void main(String[] args) {
        String string = "leetcode";
        String[] wordDict = new String[]{"leet", "code"};
        System.out.println("Is it present: " + wordBreak(string, wordDict));
    }
}
