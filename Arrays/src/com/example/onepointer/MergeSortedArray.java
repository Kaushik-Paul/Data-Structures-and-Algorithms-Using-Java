package com.example.onepointer;

import java.util.Arrays;

public class MergeSortedArray {

    // O(m + n) time and O(1) space
    public static void mergeArray(int[] array1, int[] array2, int length1, int length2) {
        mergeArrayHelper(array1, array2, length1 - 1, length2 - 1);
    }

    private static void mergeArrayHelper(int[] array1, int[] array2, int length1, int length2) {
        int last = length1 + length2 + 1;
        while (length1 >= 0 && length2 >= 0) {
            if (array1[length1] > array2[length2]) {
                array1[last] = array1[length1];
                length1--;
            } else {
                array1[last] = array2[length2];
                length2--;
            }
            last--;
        }

        // fill array1 with leftover array2 elements
        while (length2 >= 0) {
            array1[last] = array2[length2];
            length2--;
            last--;
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 2, 3, 0, 0, 0};
        int[] array2 = new int[]{1, 5, 6};
        mergeArray(array1, array2, 3, 3);
        System.out.println("After Merge: " + Arrays.toString(array1));
    }
}
