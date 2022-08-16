package com.example;

import java.util.NoSuchElementException;

public class QuickSelect {

    public int quickSelect(int[] array, int k) {
        return quickSelectHelper(array, k - 1, 0, array.length - 1);
    }

    private int quickSelectHelper(int[] array, int k, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            throw new NoSuchElementException("There is No Such Element");
        }
        int pivotIdx = startIdx;
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;
        while (leftIdx <= rightIdx) {
            if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            }
            if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            }
            if (array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }
        swap(array, pivotIdx, rightIdx);
        if (rightIdx == k) {
            return array[rightIdx];
        } else if (rightIdx < k) {
            return quickSelectHelper(array, k, rightIdx + 1, endIdx);
        } else {
            return quickSelectHelper(array, k, startIdx, rightIdx - 1);
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        QuickSelect quickSelect = new QuickSelect();
        int[] array = new int[]{8, 5, 2, 9, 7, 6, 3};
        System.out.println("The kth smallest element is: " + quickSelect.quickSelect(array, 4));
    }
}
