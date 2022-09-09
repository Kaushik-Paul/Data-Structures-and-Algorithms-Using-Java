package com.example;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // O(n) time and O(n) space
    public static boolean isValidAnagram(String source, String target) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        // Traverse the target string
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) <= 0) {
                    return false;
                } else {
                    map.replace(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String source = "anagram";
        String target = "nagaram";
        System.out.println("Is the String valid Anagram: " + isValidAnagram(source, target));
    }
}
