package com.example;

import java.util.Arrays;

public class MoveElementToEnd {

    // O(n) time and O(1) space
    public static void moveElementToEnd(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[right] == target) {
                right--;
                continue;
            }
            if (array[left] == target) {
                swap(array, left, right);
            }
            left++;
        }
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 2, 2, 2, 3, 4, 2};
        moveElementToEnd(array, 2);
        System.out.println("After Moving Element to end: " + Arrays.toString(array));

    }
}
