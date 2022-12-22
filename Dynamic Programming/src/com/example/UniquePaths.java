package com.example;

import java.util.Arrays;

public class UniquePaths {

    // O(m * n) time and O(m) space
    public static int getNumberOfUniquePaths(int m, int n) {
        int[] row = new int[m];
        Arrays.fill(row, 1);
        for (int i = 1; i < n; i++) {
            int[] newRow = new int[m];
            Arrays.fill(newRow, 1);
            for (int j = m - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        return row[0];
    }

    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        System.out.println("The Number of Unique Paths are: " + getNumberOfUniquePaths(m, n));
    }
}
