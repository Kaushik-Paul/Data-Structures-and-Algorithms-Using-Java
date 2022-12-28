package com.example;

import java.util.Arrays;

public class WiggleSort2 {

    // O(nlog n) time and O(n) space
    public static void wiggleSort(int[] array) {
        Arrays.sort(array);
        int[] result = new int[array.length];
        int left = 1;
        int right = array.length - 1;
        while (left < array.length) {
            result[left] = array[right];
            left += 2;
            right--;
        }
        left = 0;
        while (left < array.length) {
            result[left] = array[right];
            left += 2;
            right--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSort(array);
        System.out.println("After Wiggle Sorting : " + Arrays.toString(array));
    }
}
