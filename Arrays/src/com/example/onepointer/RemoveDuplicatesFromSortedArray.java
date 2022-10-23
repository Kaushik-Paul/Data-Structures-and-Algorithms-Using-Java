package com.example.onepointer;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    // O(n) time and O(1) space
    public static int removeDuplicates(int[] array) {
        int left = 1;
        int right = 1;
        while (right < array.length) {
            if (array[right] != array[right - 1]) {
                array[left] = array[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("The Number of Unique Elements is: " + removeDuplicates(array));
        System.out.println("After Removing Duplicates: " + Arrays.toString(array));
    }
}
