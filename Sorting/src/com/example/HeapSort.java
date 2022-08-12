package com.example;

import java.util.Arrays;

public class HeapSort {

    public void heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            swap(0, i,array);
            shiftDown(0, i - 1, array);
        }
    }

    private void swap(int indexOne, int indexTwo, int[] array) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private void shiftDown(int currentIdx, int endIdx, int[] array) {
        int childOne = (currentIdx * 2) + 1;
        while (childOne <= endIdx) {
            int valueToSwap = childOne;
            int childTwo = (currentIdx * 2) + 2;
            if (childTwo <= endIdx && array[childTwo] > array[childOne]) {
                valueToSwap = childTwo;
            }
            if (array[currentIdx] < array[valueToSwap]) {
                swap(currentIdx, valueToSwap, array);
            } else {
                break;
            }
            currentIdx = valueToSwap;
            childOne = (currentIdx * 2) + 1;
        }
    }

    private void buildHeap(int[] array) {
        for (int parentIdx = (array.length - 2) / 2; parentIdx >= 0; parentIdx--) {
            shiftDown(parentIdx, array.length-1, array);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        HeapSort heap = new HeapSort();
        heap.heapSort(array);
        System.out.println("Sorted array after heap sort : " + Arrays.toString(array));
    }
}
