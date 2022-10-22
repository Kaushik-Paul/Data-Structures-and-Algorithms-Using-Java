package com.example.onepointer;

import java.util.Arrays;

public class MoveZeroes {

    // Without Maintaining order
    // O(n) time and O(1) space
    public static void moveZeroesWithoutOrder(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (array[right] == 0) {
                right--;
            }
            if (array[left] == 0) {
                swap(array, left, right);
            }
            left++;
        }
    }

    // With Maintaining Order
    // O(n) time and O(1) space
    public static void moveZeroesWithOrder(int[] array) {
        int left = 0;
        int right = 0;
        while (right < array.length) {
            if (array[right] != 0) {
                swap(array, left, right);
                left++;
            }
            right++;
        }
    }

    // Snowball Solution - Leetcode Solution
    // O(n) time and O(1) space
    // Link - https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
    public static void moveZeroesSnowball(int[] array) {
        int snowBallSize = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                array[i - snowBallSize] = array[i];
                array[i] = 0;
            }
        }
    }


    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 3, 12};
        moveZeroesWithOrder(array);
        System.out.println("After Moving Zeroes to the end: " + Arrays.toString(array));
    }
}
