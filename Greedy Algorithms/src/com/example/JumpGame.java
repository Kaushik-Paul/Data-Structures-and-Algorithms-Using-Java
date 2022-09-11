package com.example;

public class JumpGame {

    // O(n) time and O(1) space
    public static boolean isJumpPossible(int[] array) {
        int goal = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] + i >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 1, 4};
        System.out.println("Is it possible to reach the goal post: " + isJumpPossible(array));
    }
}
