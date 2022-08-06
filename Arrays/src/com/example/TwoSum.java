package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    public static int[] twoSum(int[] array, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            int diff = target - num;
            if (set.contains(diff)) {
                return new int[]{diff, num};
            }
            set.add(num);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println("The sum of two numbers are: " + Arrays.toString(twoSum(array, target)));
    }
}
