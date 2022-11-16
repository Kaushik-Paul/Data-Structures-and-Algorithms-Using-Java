package com.example.onepointer;

import java.util.Arrays;

public class WaveSort {

    // Our aim is to generate the Wave Graph. The aim can be accomplished by aiming at generating the peaks in the array
    // or aiming at generating the valleys in the array. So, let us try to generate peaks in the array. Since we want
    // the first array to be the peak, we will leave it as it is and start from the index = 2. Here, since we want to
    // generate a peak, we need to have the previous and next elements smaller than our current elements. So, we will
    // check that if our previous element is larger than our element, we will swap them. Again, at the same position,
    // we will also check that the next element should be smaller than our current element. If it is not, swap these 2
    // elements
    // O(n) time and O(1) space
    public static void waveSort(int[] array) {

        for (int i = 0; i < array.length; i+=2) {
            if (i > 0 && array[i] < array[i - 1]) {
                swap(array, i, i - 1);
            }
            if (i < array.length - 1 && array[i] < array[i + 1]) {
                swap(array, i, i + 1);
            }
        }
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 6, 3, 4, 7, 2};
        waveSort(array);
        System.out.println("After Wave Sorting the elements: " + Arrays.toString(array));
    }
}
