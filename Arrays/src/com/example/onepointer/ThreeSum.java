package com.example.onepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // O(n^2) time and O(1) space
    public static List<int[]> threeSum(int[] array, int target) {
        Arrays.sort(array);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            int newTarget = target - array[i];
            while (left < right) {
                if (array[left] + array[right] > newTarget) {
                    right--;
                } else if (array[left] + array[right] < newTarget) {
                    left++;
                } else {
                    list.add(new int[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        int target = 0;
        System.out.println("The Three Sums are: ");
        List<int[]> list = threeSum(array, target);
        list.forEach(value -> System.out.print(Arrays.toString(value) + ", "));
    }
}
