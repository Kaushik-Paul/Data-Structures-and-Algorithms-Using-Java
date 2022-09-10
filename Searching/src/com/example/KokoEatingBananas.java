package com.example;

import java.util.Arrays;

public class KokoEatingBananas {

    public static int minimumEatingSpeed(int[] piles, int hours) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int minEatingRate = right;

        while (left < right) {
            int middle = (left + right) / 2;

            int currentEatingRate = 0;
            for (int pile : piles) {
                currentEatingRate += Math.ceil((double) pile / middle);
            }
            if (currentEatingRate <= hours) {
                minEatingRate = Math.min(minEatingRate, middle);
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return minEatingRate;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3, 6, 7, 11};
        int hours = 8;
        System.out.println("Minimum Eating Rate of Koko: " + minimumEatingSpeed(piles, hours));
    }
}
