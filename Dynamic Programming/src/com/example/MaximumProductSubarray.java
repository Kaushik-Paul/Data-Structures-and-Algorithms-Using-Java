package com.example;

public class MaximumProductSubarray {

    // Does not handle the edge cases
    public static int maximumProductSubarray(int[] array) {
        int[] maxProduct = array.clone();
        for (int i = array.length - 2; i >= 0; i--) {
            maxProduct[i] = Math.max(maxProduct[i], maxProduct[i] * maxProduct[i + 1]);
        }
        return maxProduct[0];
    }

    // Correct solution with edge case handled
    // O(n) time and O(1) space
    public static int maximumProductSubarrayV2(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int result = array[0];
        int min = 1, max = 1;
        for (int num : array) {
            int temp = max * num;
            max = Math.max(num * max, Math.max(num * min, num));
            min = Math.min(temp, Math.min(num * min, num));
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1,-2,-3};
        int[] array2 = new int[]{2, 3, -2, 4};
        System.out.println("The Maximum Product of Subarray is: " + maximumProductSubarrayV2(array));
    }
}
