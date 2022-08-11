package com.example;

import java.util.Arrays;

public class MinimumNumberOfCoinsForChange {

    public static int minimumNumberOfCoinsForChange(int[] denoms, int target) {
        int[] minOfCoins = new int[target + 1];
        Arrays.fill(minOfCoins, Integer.MAX_VALUE);
        minOfCoins[0] = 0;
        for (int denom : denoms) {
            for (int amount = 1; amount < minOfCoins.length; amount++) {
                if (amount >= denom) {
                    minOfCoins[amount] = Math.min(minOfCoins[amount], 1 + minOfCoins[amount - denom]);
                }
            }
        }
        return minOfCoins[target];
    }

    public static void main(String[] args) {
        int[] denoms = new int[]{1, 2, 4};
        int amount = 6;
        System.out.println("The minimum number of coins needed to make the change is : " + minimumNumberOfCoinsForChange(denoms, amount));
    }
}
