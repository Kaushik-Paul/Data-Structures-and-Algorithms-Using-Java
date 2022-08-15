package com.example;

import java.util.Arrays;

public class ThreeLargestNumber {

    // O(n) time and O(1) space
    public int[] findThreeLargestNumber(int[] array) {
        int[] largest = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            updateLargest(num, largest);
        }
        return largest;
    }

    private void updateLargest(int num, int[] largest) {
        if (largest[2] < num) {
            shiftAndUpdate(largest, num, 2);
        } else if (largest[1] < num) {
            shiftAndUpdate(largest, num, 1);
        } else if (largest[0] < num) {
            shiftAndUpdate(largest, num, 0);
        }
    }

    private void shiftAndUpdate(int[] largest, int num, int index) {
        for (int i = 0; i < index; i++) {
            largest[i] = largest[i + 1];
        }
        largest[index] = num;
    }

    public static void main(String[] args) {
        ThreeLargestNumber threeLargestNumber = new ThreeLargestNumber();
        int[] array = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int [] largest= threeLargestNumber.findThreeLargestNumber(array);
        System.out.println("The Three largest numbers are : " + Arrays.toString(largest));
    }
}

