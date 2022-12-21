package com.example.onepointer;

public class ContainerWithMostWater {

    // O(n) time and O(1) space
    public static int containerWithMostWater(int[] array) {
        int startIdx = 0;
        int endIdx = array.length - 1;
        int maxArea = 0;
        while (startIdx < endIdx) {
            int minHeight = Math.min(array[startIdx], array[endIdx]);
            int currentArea = minHeight * (endIdx - startIdx);
            maxArea = Math.max(maxArea, currentArea);
            if (array[startIdx] <= array[endIdx]) {
                startIdx++;
            } else {
                endIdx--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum Capacity of Water is: " + containerWithMostWater(array));
    }
}
