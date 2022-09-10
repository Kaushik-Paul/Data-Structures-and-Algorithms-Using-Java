package com.example.onepointer;

public class ContainerWithMostWater {

    public static int containerWithMostWater(int[] array) {
        int left = 0;
        int right = array.length - 1;

        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int minHeight = Math.min(array[left], array[right]);
            int currentArea = minHeight * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (array[left] <= array[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum Capacity of Water is: " + containerWithMostWater(array));
    }
}
