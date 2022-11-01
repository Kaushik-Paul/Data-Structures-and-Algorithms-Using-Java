package com.example;

import java.util.Arrays;

public class PlusOne {

    // O(n) time and O(1) space
    // Solution provided by Nick White
    public static int[] plusOne(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < 9) {
                array[i]++;
                return array;
            }
            array[i] = 0;
        }
        int[] newNumber = new int[array.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 9};
        System.out.println("The Result Array is: " + Arrays.toString(plusOne(array)));
    }
}
