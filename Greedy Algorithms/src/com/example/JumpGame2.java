package com.example;

import java.util.Arrays;

public class JumpGame2 {

    // O(n^2) time and 0(n) space
    public static int minimumJump(int[] array) {
        int[] minimumJumpArray = new int[array.length];
        Arrays.fill(minimumJumpArray, Integer.MAX_VALUE);
        minimumJumpArray[array.length - 1] = 0;

        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                minimumJumpArray[i] = 1;
            } else {
                for (int j = 1; j <= array[i]; j++) {
                    minimumJumpArray[i] = Math.min(minimumJumpArray[i], minimumJumpArray[j + i]);
                }
                minimumJumpArray[i] += 1;
            }
        }
        return minimumJumpArray[0];
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 1, 4};
        System.out.println("The Minimum Number of Jump is: " + minimumJump(array));
    }
}
