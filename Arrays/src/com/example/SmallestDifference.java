package com.example;

import java.util.Arrays;
import java.util.Map;

public class SmallestDifference {

    // O(n log(n) + m log(m)) time O(1) space
    public static int[] smallestDifference(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int pointer1 = 0;
        int pointer2 = 0;
        int[] smallestArray = new int[2];
        int smallestDiff = Integer.MAX_VALUE;
        while (pointer1 < array1.length && pointer2 < array2.length) {
            int currentSum = Math.abs(array1[pointer1] - array2[pointer2]);
            if (smallestDiff > currentSum) {
                smallestDiff = currentSum;
                smallestArray[0] = array1[pointer1];
                smallestArray[1] = array2[pointer2];
            }
            if (array1[pointer1] < array2[pointer2]) {
                pointer1++;
            } else if (array1[pointer1] > array2[pointer2]) {
                pointer2++;
            } else {
                break;
            }
        }
        return smallestArray;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{-1, 5, 10, 20, 28, 3};
        int[] array2 = new int[]{26, 134, 135, 15, 17};
        System.out.println("The Smallest Difference between two Arrays is: " + Arrays.toString(smallestDifference(array1, array2)));
    }
}
