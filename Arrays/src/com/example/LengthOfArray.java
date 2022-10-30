package com.example;

public class LengthOfArray {

    // O(n) time and O(1) space
    public static int lengthOfArray(int[] array) {
        int length = 0;
        try {
            while (true) {
                int num = array[length];
                length++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return length;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println("Length of the array is: " + lengthOfArray(array));
    }
}
