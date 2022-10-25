package com.example;

public class ShortestUnsortedContinuousSubarray {

    // O(n) time and O(1) space
    public static int getUnsortedSubarray(int[] array) {
        int max = array[0];
        int end = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < max) {
                end = i;
            } else {
                max = array[i];
            }
        }

        int min = array[array.length - 1];
        int start = -1;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > min) {
                start = i;
            } else {
                min = array[i];
            }
        }
        return end - start + 1;
    }

    // we can also find by sorting the array and find the start and end
    // it will be in O(nlog n) time and O(n) space

    public static void main(String[] args) {
        int[] array = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println("The Shortest Unsorted Continuous Subarray is: " + getUnsortedSubarray(array));
    }
}
