package com.example;

public class WordSearch {
    // O(m * n) time and O(m * n) space
    public static boolean isWordExist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] isVisited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(board, word, 0, i, j, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord(char[][] board, String word, int index, int i, int j, boolean[][] isVisited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        isVisited[i][j] = true;
        if (
                searchWord(board, word, index + 1, i+1, j, isVisited) ||
                searchWord(board, word, index + 1, i-1, j, isVisited) ||
                searchWord(board, word, index + 1, i, j+1, isVisited) ||
                searchWord(board, word, index + 1, i, j-1, isVisited)
        ) {
            return true;
        }
        isVisited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println("Is the word present: " + isWordExist(board, word));
    }
}
