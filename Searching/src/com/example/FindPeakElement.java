package com.example;

public class FindPeakElement {

    // O(log n) time and O(1) space
    public static int findPeakElement(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else if (array[mid] < array[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 1, 3, 5, 6, 4};
        int[] array2 = new int[]{1, 2, 3, 1};
        System.out.println("The Index of the Peak Element is: " + findPeakElement(array));
    }
}
