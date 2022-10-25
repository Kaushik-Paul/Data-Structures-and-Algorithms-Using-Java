package com.example;

import java.util.Arrays;

public class RotateArray {

    // O(n) time and O(n) space
    public static void rotateArrayWithSpace(int[] array, int k) {
        int[] shiftedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int index = (i + k) % array.length;
            shiftedArray[index] = array[i];
        }
        System.arraycopy(shiftedArray, 0, array, 0, array.length);
    }

    // O(n) time and O(1) space
    public static void rotateArrayWithoutSpace(int[] array, int k) {
        // Reverse the array
        int left = 0;
        int right = array.length - 1;
        reverseArray(array, left, right);

        // Reverse the First half
        left = 0;
        right = k - 1;
        reverseArray(array, left, right);

        // Reverse the second half
        left = k;
        right = array.length - 1;
        reverseArray(array, left, right);
    }

    private static void reverseArray(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArrayWithoutSpace(array, k);
        System.out.println("After Rotating Array clockwise: " + Arrays.toString(array));
    }
}
