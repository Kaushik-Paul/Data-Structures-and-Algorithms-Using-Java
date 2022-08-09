package com.example;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        int[] arr = new int[]{3, 6, 9, 10, 11, 45, 88};
        bubbleSort(array);
        System.out.print("The sorted array is : ");
        for (int i : array) {
            System.out.print(i+" , ");
        }
    }
}
