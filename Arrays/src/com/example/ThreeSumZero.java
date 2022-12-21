package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {

    // O(n^2) time and O(n) space
    public static List<List<Integer>> threeSumWithoutDuplication(int[] array) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int target = 0 - array[i];
            int low = i + 1;
            int high = array.length - 1;
            while (low < high) {
                if (array[low] + array[high] == target) {
                    result.add(List.of(array[i], array[low], array[high]));
                    // To remove duplicate
                    while (low < high && array[low] == array[low + 1]) {
                        low++;
                    }
                    while (low < high && array[high] == array[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (array[low] + array[high] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Three Number Sum Without Duplicate is: " + threeSumWithoutDuplication(array));
    }
}
