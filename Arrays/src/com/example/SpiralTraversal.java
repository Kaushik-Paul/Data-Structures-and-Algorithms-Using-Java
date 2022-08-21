package com.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    // O(n) time and O(n) space
    public static List<Integer> spiralTraversal(int[][] array) {
        List<Integer> integerList = new ArrayList<>();
        int startRow = 0, endRow = array.length - 1;
        int startCol = 0, endCol = array[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                integerList.add(array[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++) {
                integerList.add(array[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--) {
                integerList.add(array[endRow][col]);
            }
            for (int row = endRow - 1; row >= startRow + 1; row--) {
                integerList.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return integerList;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        System.out.println("Spiral Traversal : " + spiralTraversal(array));
    }
}
