package com.example;

public class SearchInsertPosition {

    // O(log n) time and O(1) space
    // Leetcode 35
    public static int searchInsertPosition(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6};
        int target = 2;
        System.out.println("The Position of the number is: " + searchInsertPosition(array, target));
    }
}
