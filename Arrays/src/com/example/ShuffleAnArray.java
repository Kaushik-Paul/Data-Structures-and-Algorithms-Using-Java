package com.example;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] array;
    private Random random;

    public ShuffleAnArray(int[] array) {
        this.array = array;
        this.random = new Random();
    }

    // O(1) time and O(1) space
    public int[] reset() {
        return this.array;
    }

    // O(n) time and O(n) space
    public int[] shuffle() {
        int[] randomArray = this.array.clone();
        for (int i = randomArray.length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            int temp = randomArray[i];
            randomArray[i] = randomArray[randomIndex];
            randomArray[randomIndex] = temp;
        }
        return randomArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(array);
        System.out.println("After Shuffle: " + Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println("After Reset: " + Arrays.toString(shuffleAnArray.reset()));
        System.out.println("After Shuffle: " + Arrays.toString(shuffleAnArray.shuffle()));

    }
}
