package com.example;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // O(n * 2^n) time and O(n) space
    public static List<List<String>> partitionPalindrome(String string) {
        List<List<String>> result = new ArrayList<>();
        partitionDfs(string, 0, new ArrayList<>(), result);
        return result;
    }

    private static void partitionDfs(String string, int start, ArrayList<String> list, List<List<String>> result) {
        if (start == string.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < string.length(); i++) {
            if (isPalindrome(string, start, i)) {
                list.add(string.substring(start, i + 1));
                partitionDfs(string, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String string, int start, int end) {
        if (start > end) {
            return false;
        }
        while (start <= end) {
            if (string.charAt(start) != string.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "aab";
        System.out.println("All Palindrome partitioning are: " + partitionPalindrome(string));
    }
}
