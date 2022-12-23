package com.example;

import java.util.Arrays;

public class SurroundingRegions {

    // O(m * n) time and O(1) space
    public static void convertSurroundingRegion(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == '0') {
                boundaryDfs(board, i, 0);
            }
            if (board[i][columns - 1] == '0') {
                boundaryDfs(board, i, columns - 1);
            }
        }
        for (int j = 0; j < columns; j++) {
            if (board[0][j] == '0') {
                boundaryDfs(board, 0, j);
            }
            if (board[rows - 1][j] == '0') {
                boundaryDfs(board, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == '0') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = '0';
                }
            }
        }
    }

    private static void boundaryDfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }
        if (board[i][j] == '0') {
            board[i][j] = '*';
        }
        if (i > 0 && board[i - 1][j] == '0') {
            boundaryDfs(board, i - 1, j);
        }
        if (i < board.length - 1 && board[i + 1][j] == '0') {
            boundaryDfs(board, i + 1, j);
        }
        if (j > 0 && board[i][j - 1] == '0') {
            boundaryDfs(board, i, j - 1);
        }
        if (j < board.length - 1 && board[i][j + 1] == '0') {
            boundaryDfs(board, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', '0', '0', 'X'}, {'X', 'X', '0', 'X'}, {'X', '0', 'X', 'X'}};
        convertSurroundingRegion(board);
        System.out.print("After Conversion: ");
        for (char[] ch : board) {
            System.out.print(Arrays.toString(ch) + ", ");
        }
    }
}
