package com.example;

public class ShiftedBinarySearch {

    public static int shiftedBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[left] <= array[mid]) {
                if (target >= array[left] && target < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= array[right] && target > array[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 45};
        int index = shiftedBinarySearch(array, 33);
        if (index == -1) {
            System.out.println("Number is not present");
        } else {
            System.out.println("The number is present is present at : " + index);
        }
    }
}
