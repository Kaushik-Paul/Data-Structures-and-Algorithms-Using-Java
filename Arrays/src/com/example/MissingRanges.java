package com.example;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    // O(n) time and O(n) space
    public static List<String> missingRanges(int[] array, int lower, int upper) {
        List<String> result = new ArrayList<>();
        for (int num : array) {
            if (num > lower) {
                if (num - lower == 1) {
                    result.add(String.valueOf(lower));
                } else {
                    result.add(lower + "->" + (num - 1));
                }
            }

            lower = num + 1;
        }
        if (lower < upper) {
            result.add(lower + "->" + upper);
        } else if (lower == upper) {
            result.add(String.valueOf(lower));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 3, 50, 75};
        int lower = 0;
        int higher = 99;
        System.out.println("The Missing Ranges are: " + missingRanges(array, lower, higher));
    }
}
