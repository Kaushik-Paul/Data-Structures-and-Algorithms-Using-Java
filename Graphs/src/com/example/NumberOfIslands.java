package com.example;

public class NumberOfIslands {

    // O(m * n) time and O(1) space
    public static int numberOfIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    changeAllAdjacentIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void changeAllAdjacentIslands(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        changeAllAdjacentIslands(grid, i + 1, j); // down
        changeAllAdjacentIslands(grid, i - 1, j); // up
        changeAllAdjacentIslands(grid, i, j + 1); // right
        changeAllAdjacentIslands(grid, i, j - 1); // left
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("The Number of Islands are: " + numberOfIslands(grid));
    }
}
