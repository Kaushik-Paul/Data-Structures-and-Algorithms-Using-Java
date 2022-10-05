package com.example;

import java.util.Arrays;

public class StartAndEndOfTarget {

    // O(log n) time and O(1) space
    public static int[] findFirstAndLastPosition(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int[] position = new int[]{-1, -1};
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < array[middle]) {
                right = middle - 1;
            } else if (target > array[middle]) {
                left = middle + 1;
            } else {
                // Iterate neighbours for left and right positions
                if (array[middle - 1] == target) {
                    int leftPosition = middle - 1;
                    while (array[leftPosition] == target) {
                        leftPosition--;
                    }
                    position[0] = leftPosition + 1;
                }else {
                    position[0] = middle;
                }
                if (array[middle + 1] == target) {
                    int rightPosition = middle + 1;
                    while (array[rightPosition] == target) {
                        rightPosition++;
                    }
                    position[1] = rightPosition - 1;
                } else {
                    position[1] = middle;
                }
                return position;
            }
        }
        return position;
    }

    // O(log n) time and O(1) space
    // more optimal
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums,target);
        result[1] = findLast(nums,target);
        return result;
    }

    private static int findFirst(int[] nums, int target){
        int result = -1;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if (nums[mid] < target){
                low = mid +1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else { // nums[mid] == target
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }

    private static int findLast(int[] nums, int target){
        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;

            if (nums[mid] < target){
                low = mid +1;
            } else if (nums[mid] > target){
                high = mid - 1;
            } else { // nums[mid] == target
                result = mid;
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 3, 5, 5, 5, 8, 9};
        int target = 5;
        System.out.println("The Start and End Index are: " + Arrays.toString(searchRange(array, target)));
    }
}
