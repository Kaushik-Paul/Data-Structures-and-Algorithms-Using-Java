package com.example;

public class KthLargestElement {

    // O(n) time and O(n) space
    // Used Quick Select Algorithm
    public static int kThLargestElement(int[] array, int k) {
        return kthLargestElementHelper(array, k - 1, 0, array.length - 1);
    }

    private static int kthLargestElementHelper(int[] array, int k, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return Integer.MIN_VALUE;
        }
        int pivotIdx = startIdx;
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;
        while (leftIdx <= rightIdx) {
            if (array[pivotIdx] > array[leftIdx] && array[pivotIdx] < array[rightIdx]) {
                swap(array, leftIdx, rightIdx);
            }
            if (array[pivotIdx] <= array[leftIdx]) {
                leftIdx++;
            }
            if (array[pivotIdx] >= array[rightIdx]) {
                rightIdx--;
            }
        }
        swap(array, pivotIdx, rightIdx);
        if (rightIdx == k) {
            return array[rightIdx];
        } else if (rightIdx > k) {
           return kthLargestElementHelper(array, k, startIdx, rightIdx - 1);
        } else {
            return kthLargestElementHelper(array, k, rightIdx + 1, endIdx);
        }
    }

    private static void swap(int[] array, int leftIdx, int rightIdx) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("The " + k + "th Largest Element is: " + kThLargestElement(array, k));
    }
}
