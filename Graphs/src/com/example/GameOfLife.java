package com.example;

import java.util.Arrays;

public class GameOfLife {

    // Original  |  New  |  State
    //    0      |   0   |    0
    //    1      |   0   |    1
    //    0      |   1   |    2
    //    1      |   1   |    3

    // live cell with neighbour < 2 -> dies
    // live cell with neighbour in [2, 3] -> lives
    // live cell with neighbour > 3 -> dies
    // dead cell with neighbour = 3 -> lives


    // O(m * n) time and O(1) space
    public static void nextState(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighbours = countLiveNeighbours(board, i, j);
                if (board[i][j] == 1) {
                    if (liveNeighbours == 2 || liveNeighbours == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (liveNeighbours == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] = 1;
                } else if (board[i][j] == 1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int countLiveNeighbours(int[][] board, int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if ((i == row && j == col) || i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                    continue;
                }
                if (board[i][j] == 1 || board[i][j] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}
        };
        nextState(board);
        System.out.print("The Next State of the Board is: ");
        for (int[] nums : board) {
            System.out.print(Arrays.toString(nums) + ", ");
        }
    }
}
