package com.example;

import java.util.Arrays;

public class SortColors {

    // O(n) time and O(1) space
    // Move all 0 to front, move all 2 to back and keep 1 in the middle
    public static void sortColors(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        int index = 0;
        while (start < end && index <= end) {
            if (array[index] == 0) {
                array[index] = array[start];
                array[start] = 0;
                index++;
                start++;
            } else if (array[index] == 2) {
                array[index] = array[end];
                array[end] = 2;
                index++;
                end--;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(array);
        System.out.println("Array after sorting with colors: " + Arrays.toString(array));
    }
}
