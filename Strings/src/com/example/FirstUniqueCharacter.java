package com.example;

public class FirstUniqueCharacter {

    // O(n) time and O(1) space
    public static int firstUniqueCharacter(String string) {
        int[] frequency = new int[26];
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            frequency[ch - 'a'] += 1;
        }
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (frequency[ch - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String string = "loveleetcode";
        System.out.println("The First Unique Character is at position: " + firstUniqueCharacter(string));
    }
}
