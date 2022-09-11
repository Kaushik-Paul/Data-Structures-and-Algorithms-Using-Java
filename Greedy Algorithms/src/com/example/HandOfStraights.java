package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

    public static boolean handOfStraights(int[] array, int groupSize) {
        if (array.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(array);
        for (int num : array) {
            if (map.get(num) <= 0) {
                continue;
            }
            for (int i = 1; i < groupSize; i++) {
                int count = map.getOrDefault(num + i, 0);
                if (count <= 0) {
                    return false;
                } else {
                    // Reduce the count of consequent numbers
                    map.put(num + i, count - 1);
                }
            }
            // Reduce the count for the present number
            map.put(num, map.get(num) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println("Alice hand can be arranged: " + handOfStraights(array, groupSize));
    }
}
