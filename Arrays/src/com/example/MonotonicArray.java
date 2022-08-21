package com.example;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                increasing = false;
            }
            if (array[i] < array[i + 1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println("Is The array Monotonic: " + isMonotonic(array));
    }
}
