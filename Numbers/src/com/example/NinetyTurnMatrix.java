package com.example;

import java.util.Arrays;

public class NinetyTurnMatrix {

    public int[][] returnTranspose(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        return array;
    }

    public void ninetyDegreeTurn(int[][] array) {
        System.out.println("Before Transpose: " + Arrays.deepToString(array));
        int[][] newArray = returnTranspose(array);
        System.out.println("After Transpose: " + Arrays.deepToString(newArray));

    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new NinetyTurnMatrix().ninetyDegreeTurn(array);
    }
}
