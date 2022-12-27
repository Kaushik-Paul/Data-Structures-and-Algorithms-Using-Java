package com.example;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // O(n) time and O(1) space
    public static int[] productOfArrayWithDivision(int[] array) {
        int totalProduct = 1;
        int[] arrayOfProduct = new int[array.length];
        for (int num : array) {
            totalProduct *= num;
        }
        for (int i = 0; i < array.length; i++) {
            arrayOfProduct[i] = totalProduct / array[i];
        }
        return arrayOfProduct;
    }

    // O(n) time and O(n) space
    public static int[] productOfArrayWithoutDivision(int[] array) {
        int N = array.length;
        int[] leftArray = new int[N];
        int[] rightArray = new int[N];
        int[] outputArray = new int[N];
        leftArray[0] = 1;
        rightArray[N - 1] = 1;
        // Calculate all the product except self of the left side
        for (int i = 1; i < N; i++) {
            leftArray[i] = leftArray[i - 1] * array[i - 1];
        }
        // Calculate all the product except self of the right side
        for (int i = N - 2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] * array[i + 1];
        }
        // Multiply the result of both the array to get the desired result
        for (int i = 0; i < N; i++) {
            outputArray[i] = leftArray[i] * rightArray[i];
        }
        return outputArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        System.out.println("Product Of Array Except Self is: " + Arrays.toString(productOfArrayWithoutDivision(array)));
    }
}
