package com.example;

public class MajorityElement {

    // O(n) time and O(1) space
    public static int getMajorityElement(int[] array) {
        int result = 0, count = 0;
        for (int num : array) {
            if (count == 0) {
                result = num;
            }
            if (num == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println("The Majority Element is: " + getMajorityElement(array));
    }
}
