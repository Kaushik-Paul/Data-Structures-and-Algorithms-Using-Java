package com.example;

public class IncreasingTripletSubsequence {

    // O(n) time and O(1) space
    public static boolean isIncreasingTripletSubsequence(int[] array) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= first) {
                first = array[i];
            } else if (array[i] <= second) {
                second = array[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 5, 0, 4, 6};
        System.out.println("Is the array Increasing Triplet Subsequence: " + isIncreasingTripletSubsequence(array));
    }
}
