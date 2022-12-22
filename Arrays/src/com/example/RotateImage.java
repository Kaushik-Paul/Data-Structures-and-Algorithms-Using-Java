package com.example;

import java.util.Arrays;

public class RotateImage {

    // O(m*n) time and O(1) space
    public static void rotateImage(int[][] array) {
        int N = array.length;
        // Transpose the array
        for (int i = 0; i < N; i++) {
            for (int j = i; j < array[i].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        
        // Swap the columns 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = array[i][j];
                array[i][j] = array[i][N - 1 - j];
                array[i][N - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateImage(array);
        System.out.println("After Rotating Image: " + Arrays.deepToString(array));
    }
}
