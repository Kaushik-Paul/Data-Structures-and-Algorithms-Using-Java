package com.example;

import java.util.Arrays;

public class CountingBits {

    public static int[] getCountingBits(int num) {
        int[] countingBits = new int[num + 1];
        int offset = 1;
        Arrays.fill(countingBits, 0);
        for (int i = 1; i < countingBits.length; i++) {
            if (i == offset * 2) {
                offset = i;
            }
            countingBits[i] = 1 + countingBits[i - offset];
        }
        return countingBits;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("The Counting Bits for 1 are: " + Arrays.toString(getCountingBits(num)));
    }
}
