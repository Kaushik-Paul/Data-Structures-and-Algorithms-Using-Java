package com.example;

import java.util.Arrays;

public class PaintHouse {

    // O(n) time and O(n) space
    public static int minimumToPaintHouse(int[][] array) {
        int[] housePaintCost = new int[]{0, 0, 0};
        for (int[] num : array) {
            int paint0 = num[0] + Math.min(housePaintCost[1], housePaintCost[2]);
            int paint1 = num[1] + Math.min(housePaintCost[2], housePaintCost[0]);
            int paint2 = num[2] + Math.min(housePaintCost[0], housePaintCost[1]);
            housePaintCost[0] = paint0;
            housePaintCost[1] = paint1;
            housePaintCost[2] = paint2;
        }
        return Arrays.stream(housePaintCost).min().getAsInt();
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {14, 2, 11},
                {11, 14, 5},
                {14, 3, 10}
        };
        System.out.println("Minimum Cost to Paint the House: " + minimumToPaintHouse(array));
    }
}
