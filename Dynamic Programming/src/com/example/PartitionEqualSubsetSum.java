package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

    public static boolean isEqualPartitionPossible(int[] array) {
        int sum = Arrays.stream(array).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int num : array) {
            Set<Integer> newSet = new HashSet<>(set);
            for (int setNum : set) {
                if (setNum + num == target) {
                    return true;
                }
                newSet.add(setNum + num);
            }
            set = new HashSet<>(newSet);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 11, 5};
        System.out.println("Is the equal partition possible: " + isEqualPartitionPossible(array));
    }
}
