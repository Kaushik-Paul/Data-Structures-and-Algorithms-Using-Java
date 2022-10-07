package com.example;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    // O(n^2) time and O(n) space
    public static int minimumPathSum(List<List<Integer>> list) {
        int[] minimumPath = new int[list.size() + 1];

        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < list.get(i).size(); j++) {
                int num = list.get(i).get(j);
                minimumPath[j] = num + Math.min(minimumPath[j], minimumPath[j + 1]);
            }
        }
        return minimumPath[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(2));
        list.add(List.of(3, 4));
        list.add(List.of(6, 5, 7));
        list.add(List.of(4, 1, 8, 3));
        System.out.println("The minimum Path For the Triangle: " + minimumPathSum(list));
    }
}
