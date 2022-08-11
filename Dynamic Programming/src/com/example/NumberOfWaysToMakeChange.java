package com.example;

import java.util.Arrays;

public class NumberOfWaysToMakeChange {

    public static int getNumberOfWaysToMakeChange(int[] denoms, int target) {
        int[] noOfCoins = new int[target + 1];
        Arrays.fill(noOfCoins, 0);
        noOfCoins[0] = 1;
        for (int denom : denoms) {
            for (int amount = 1; amount < noOfCoins.length; amount++) {
                if (amount >= denom) {
                    noOfCoins[amount] += noOfCoins[amount - denom];
                }
            }
        }
        return noOfCoins[target];
    }

    public static void main(String[] args) {
        int[] denoms = new int[]{1, 5, 10, 15};
        int amount = 10;
        System.out.println("The minimum number of coins needed to make the change is : " + getNumberOfWaysToMakeChange(denoms, amount));
    }
}
