package com.example;

public class BinarySearch {

    public static boolean isNumberPresent(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        if (isNumberPresent(array, target)) {
            System.out.println("Number is present in the array");
        } else {
            System.out.println("NUmber is not present in the array");
        }
    }
}
