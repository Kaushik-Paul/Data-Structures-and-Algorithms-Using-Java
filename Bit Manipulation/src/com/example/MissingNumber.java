package com.example;

import java.util.Arrays;

public class MissingNumber {

    public static int returnMissingNumber(int[] array) {
        // Add from length
        int total = (array.length * (array.length + 1)) / 2;
        // add the array
        int sum = Arrays.stream(array).sum();
        //return the diff
        return total - sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("The Missing Number is: " + returnMissingNumber(array));
    }
}
