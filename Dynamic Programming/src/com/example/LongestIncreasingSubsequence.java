package com.example;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // O(n^2) time and O(n) space
    public static int longestIncreasingSubsequence(int[] array) {
        int[] longestSubsequence = new int[array.length];
        Arrays.fill(longestSubsequence, 1);

        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = i; j < array.length; j++) {
                if (array[i] < array[j]) {
                    longestSubsequence[i] = Math.max(longestSubsequence[i], 1 + longestSubsequence[j]);
                }
            }
        }
        return Arrays.stream(longestSubsequence).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("The longest Subsequence is: " + longestIncreasingSubsequence(array));
    }
}
