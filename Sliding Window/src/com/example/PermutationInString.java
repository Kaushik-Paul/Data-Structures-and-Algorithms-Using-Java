package com.example;

public class PermutationInString {

    // O(26 * n) time and O(1) space
    public static boolean isPermutatedStringPresent(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = 0;
        while (j < s1.length()) {
            count[s2.charAt(j) - 'a']--;
            j++;
        }

        if (isArrayEmpty(count)) {
            return true;
        }
        // Reset j to one pos behind due to increment in loop
        j--;

        while (j < s2.length()) {
            count[s2.charAt(i) - 'a']++;
            i++;
            j++;

            if (j < s2.length()) {
                count[s2.charAt(j) - 'a']--;
            }
            if (isArrayEmpty(count)) {
                return true;
            }
        }
        return isArrayEmpty(count);
    }

    private static boolean isArrayEmpty(int[] array) {
        for (int j : array) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaaoo";
        System.out.println("Is String 1's permutated string present in string 2: " + isPermutatedStringPresent(s1, s2));
    }
}
