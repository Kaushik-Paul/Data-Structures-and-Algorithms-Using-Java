package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] array) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(array).forEach(set::add);
        int longestSequence = Integer.MIN_VALUE;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + count)) {
                    count++;
                }
                longestSequence = Math.max(longestSequence, count);
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        int[] array = new int[]{100, 4, 200, 1, 3, 2};
        int[] array2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Sequence is: " + longestConsecutive(array2));
     }
}
