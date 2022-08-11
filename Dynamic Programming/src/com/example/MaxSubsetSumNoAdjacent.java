package com.example;

public class MaxSubsetSumNoAdjacent {

    public static int getMaxSubsetSumNoAdjacent(int[] array) {
        if (array.length <= 1) {
            return array[0];
        }
        int[] maxSubset = new int[array.length];
        maxSubset[array.length - 1] = array[array.length - 1];
        maxSubset[array.length - 2] = Math.max(array[array.length - 1], array[array.length - 2]);
        for (int i = array.length - 3; i >= 0; i--) {
            maxSubset[i] = Math.max(maxSubset[i + 1], array[i] + maxSubset[i + 2]);
        }
        return maxSubset[0];
    }

    public static int getMaxSubsetSumNoAdjacentNoArray(int[] array) {
        if (array.length <= 1) {
            return array[0];
        }
        int first = array[array.length - 1];
        int second = Math.max(array[array.length - 1], array[array.length - 2]);
        for (int i = array.length - 3; i >= 0; i--) {
            int third = Math.max(second, array[i] + first);
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 10, 12, 7, 9, 14};
        System.out.println("The max Sum of subset using 1st method is : " + getMaxSubsetSumNoAdjacent(array));
        System.out.println("The max Sum of subset using 1st method is : " + getMaxSubsetSumNoAdjacentNoArray(array));
    }
}
