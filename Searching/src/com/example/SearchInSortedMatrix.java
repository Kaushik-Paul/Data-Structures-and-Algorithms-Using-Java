package com.example;

import java.util.Arrays;

public class SearchInSortedMatrix {

    public static int[] isNumberPresent(int[][] array, int target) {
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] == target) {
                return new int[]{row, col};
            } else if (array[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,   4,  7,   12,  15,  1000},
                {2,   5,  19,  31,  32,  1001},
                {3,   8,  24,  33,  35,  1002},
                {40, 41,  42,  44,  45,  1003},
                {99, 100, 103, 106, 128, 1004}
        };
        int[] store = isNumberPresent(array, 44);
        if (store[0] == -1) {
            System.out.println("The number is not present in the matrix");
        } else {
            System.out.println("The number is present in the location " + Arrays.toString(store) + " of the matrix");
        }
    }
}
