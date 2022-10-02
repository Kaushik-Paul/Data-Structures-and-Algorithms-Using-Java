package com.example;

import java.util.Arrays;

public class TrappingRainwater {

    // O(n) time and O(n) space
    public static int maxRainWaterCapture(int[] array) {
        int[] maxes = new int[array.length];
        int leftMax = 0;

        for (int i = 0; i < maxes.length; i++) {
            maxes[i] = leftMax;
            leftMax = Math.max(leftMax, array[i]);
        }

        int rightMax = 0;
        for (int i = maxes.length - 1; i >= 0; i--) {
            int height = array[i];
            int minHeight = Math.min(rightMax, maxes[i]);
            if (minHeight > height) {
                maxes[i] = minHeight - height;
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(rightMax, height);
        }
        return Arrays.stream(maxes).sum();
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println("The Maximum Area can be Trapped in Rainwater is: " + maxRainWaterCapture(array));
    }
}
