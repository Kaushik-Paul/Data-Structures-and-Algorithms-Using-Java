package com.example;

public class SingleNumber {

    // O(n) time and O(1) space
    public static int getSingleNumber(int[] array) {
        int result = 0;

        for (int num : array) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 2, 1, 2};
        System.out.println("The Single Non Repeating Number is: " + getSingleNumber(array));
    }
}
