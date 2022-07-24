package com.example;

import java.util.Arrays;

public class MergeSortedArrays {

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int leftArray1 = 0, leftArray2 = 0, mergedLeft = 0;
        int[] mergedArray = new int[array1.length + array2.length - 1];
        while (leftArray1 < array1.length && leftArray2 < array2.length) {
            if (array1[leftArray1] < array2[leftArray2]) {
                mergedArray[mergedLeft] = array1[leftArray1];
                leftArray1++;
            } else if (array1[leftArray1] > array2[leftArray2]) {
                mergedArray[mergedLeft] = array2[leftArray2];
                leftArray2++;
            } else {
                mergedArray[mergedLeft] = array1[leftArray1];
                leftArray1++;
                leftArray2++;
            }
            mergedLeft++;
        }
        while (leftArray1 < array1.length) {
            mergedArray[mergedLeft] = array1[leftArray1];
            leftArray1++;
            mergedLeft++;
        }
        while (leftArray2 < array2.length) {
            mergedArray[mergedLeft] = array2[leftArray2];
            leftArray2++;
            mergedLeft++;
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{0, 3, 4, 31};
        int[] array2 = new int[]{4, 6, 30};
        System.out.println("Merged Array is: " + Arrays.toString(mergeSortedArrays(array1, array2)));
    }
}
