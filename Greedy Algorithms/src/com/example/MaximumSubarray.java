package com.example;

public class MaximumSubarray {

    public static int maximumSubarray(int[] array) {
        int maxSub = array[0];

        int currentSub = 0;
        for (int num : array) {
            currentSub += num;
            maxSub = Math.max(maxSub, currentSub);
            if (currentSub < 0) {
                currentSub = 0;
            }
        }
        return maxSub;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("The Maximum Subarray is: " + maximumSubarray(array));
    }
}
