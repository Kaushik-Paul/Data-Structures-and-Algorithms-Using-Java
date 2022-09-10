package com.example;

public class MinimumInRotatedSortedArray {

    public static int minimumInSortedArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int minimum = Integer.MAX_VALUE;
        while (left < right) {
            if (array[left] <= array[right]) {
                minimum = array[left];
                break;
            }

            int middle = (left + right) / 2;
            minimum = Math.min(minimum, array[middle]);

            if (array[left] <= array[middle]) {
                // search the right as minimum will be available at right
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        int[] array2 = new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 44};
        System.out.println("The Minimum Value is: " + minimumInSortedArray(array2));
    }
}
