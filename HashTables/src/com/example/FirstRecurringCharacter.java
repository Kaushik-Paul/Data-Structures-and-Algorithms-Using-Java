package com.example;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

    public static int firstRecurringCharacter(int[] array) {
        Set<Integer> set = new HashSet<>(array.length);
        for (int num : array) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4};
        System.out.println("The First Recurring Character is: " + firstRecurringCharacter(array));

    }
}
