package com.example;

public class MergeSort {

    private static void merge(int[] array, int startIdx, int midIdx, int endIdx) {
        int left = midIdx - startIdx + 1;
        int right = endIdx - midIdx;
        int[] leftArray = new int[left];
        int[] rightArray = new int[right];
        for (int i = 0; i < left; i++) {
            leftArray[i] = array[startIdx + i];
        }
        for (int i = 0; i < right; i++) {
            rightArray[i] = array[midIdx + 1 + i];
        }
        int i = 0, j = 0, k = startIdx;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < left) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < right) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }

    public static void sort(int[] array, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return;
        }
        int midIdx = (leftIdx + rightIdx) / 2;
        sort(array, leftIdx, midIdx);
        sort(array, midIdx + 1, rightIdx);
        merge(array, leftIdx, midIdx, rightIdx);
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        sort(array, 0, array.length - 1);
        System.out.println("The Sorted Array is : ");
        for (int i : array) {
            System.out.print(i + " , ");
        }
    }
}
