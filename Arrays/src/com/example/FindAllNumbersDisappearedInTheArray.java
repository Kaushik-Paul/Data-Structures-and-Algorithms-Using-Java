package com.example;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInTheArray {

    // O(n) time and O(1) space
    public static List<Integer> findAllDisappearedNumber(int[] array) {
        List<Integer> list = new ArrayList<>();

        for (int num : array) {
            int i = Math.abs(num) - 1;
            array[i] = -1 * Math.abs(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("The Numbers Missing from the array is: " + findAllDisappearedNumber(array));
    }
}
