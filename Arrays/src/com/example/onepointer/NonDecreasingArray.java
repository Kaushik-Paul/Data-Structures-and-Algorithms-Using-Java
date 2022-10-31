package com.example.onepointer;

public class NonDecreasingArray {

    // O(n) time and O(1) space
    public static boolean canBeNonDecreasing(int[] array) {
        boolean isChanged = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                continue;
            }
            if (isChanged) {
                return false;
            }
            //     i  i+1
            // [3, 4, 2]
            if (i == 0 || array[i + 1] >= array[i - 1]) {
                array[i] = array[i + 1];
            } else {
                array[i + 1] = array[i];
            }
            isChanged = true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 3};
        System.out.println("Is the array can be converted to non-decreasing: " + canBeNonDecreasing(array));
    }
}
