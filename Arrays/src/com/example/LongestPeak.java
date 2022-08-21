package com.example;

public class LongestPeak {

    // O(n) time and O(1) space
    public static int longestPeak(int[] array) {
        int longestPeak = 0;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                int leftIndex = i - 1;
                while (array[leftIndex] > array[leftIndex - 1]) {
                    leftIndex--;
                }
                int rightIndex = i + 1;
                while (array[rightIndex] > array[rightIndex + 1]) {
                    rightIndex++;
                }
                i = rightIndex;
                int currentPeak = rightIndex - leftIndex + 1;
                longestPeak = Math.max(currentPeak, longestPeak);
            }
        }
        return longestPeak;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println("The Longest Peak of the current array is : " + longestPeak(array));
    }
}
