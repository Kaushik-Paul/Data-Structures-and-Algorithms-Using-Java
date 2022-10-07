package com.example;

import java.util.Arrays;

public class CoinChange {

    // O(coins * amount) time and O(amount) space
    public static int minimumCoinForChange(int[] coins, int amount) {
        int[] minimumAmount = new int[amount + 1];
        Arrays.fill(minimumAmount, amount + 1);
        minimumAmount[0] = 0;

        for (int i = 1; i < minimumAmount.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    minimumAmount[i] = Math.min(minimumAmount[i], 1 + minimumAmount[i - coin]);
                }
            }
        }
        if (minimumAmount[amount] == amount + 1) {
            return -1;
        } else {
            return minimumAmount[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println("The Minimum Coins needed for change is: " + minimumCoinForChange(coins, amount));
    }
}
