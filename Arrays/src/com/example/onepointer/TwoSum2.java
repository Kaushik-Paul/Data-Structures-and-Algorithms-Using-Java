package com.example.onepointer;

import java.util.Arrays;

public class TwoSum2 {

    public static int[] twoSum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            if (array[left] + array[right] > target) {
                right--;
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println("The Two Sum of the array is: " + Arrays.toString(twoSum(array, target)));
    }
}
