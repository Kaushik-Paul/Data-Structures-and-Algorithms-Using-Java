package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static List<int[]> threeNumberSum(int[] array, int target) {
        Arrays.sort(array);
        List<int[]> sums = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == target) {
                    sums.add(new int[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        int target = 0;
        System.out.print("The three Number Sums are: ");
        threeNumberSum(array,target).forEach(s-> System.out.print(Arrays.toString(s) + " , "));
    }
}
