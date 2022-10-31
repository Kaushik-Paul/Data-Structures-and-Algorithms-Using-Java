package com.example;

public class IslandPerimeter {

    // O(m * n) time and O(1) space
    public static int getPerimeterOfIsland(int[][] array) {
        int countPerimeter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    countPerimeter += 4;
                    if (i > 0 && array[i-1][j] == 1) {
                        countPerimeter -= 2;
                    }
                    if (j > 0 && array[i][j - 1] == 1) {
                        countPerimeter -= 2;
                    }
                }
            }
        }
        return countPerimeter;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println("The perimeter of the island is: " + getPerimeterOfIsland(array));
    }
}
