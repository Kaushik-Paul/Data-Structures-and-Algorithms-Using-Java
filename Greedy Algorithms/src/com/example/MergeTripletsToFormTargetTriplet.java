package com.example;

public class MergeTripletsToFormTargetTriplet {

    // Leet Code Qno-1899
    // O(n) time and O(1) space
    public static boolean isMergingPossible(int[][] array, int[] targetTriplet) {
        boolean[] goodTriplet = new boolean[3];

        for (int[] nums : array) {
            if (nums[0] > targetTriplet[0] || nums[1] > targetTriplet[1] || nums[2] > targetTriplet[2]) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                if (nums[i] == targetTriplet[i]) {
                    goodTriplet[i] = true;
                }
            }
        }
        return goodTriplet[0] && goodTriplet[1] && goodTriplet[2];
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] targetTriplet = new int[]{2, 7, 5};
        System.out.println("Is it possible to merge triplet: " + isMergingPossible(array, targetTriplet));
    }
}
