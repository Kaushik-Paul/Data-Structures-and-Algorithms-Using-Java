package com.example;

public class BestTimeToBuyStockII {

    // O(n) time and O(1) space
    public static int profitToSellStock(int[] array) {
        int profit = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                profit += (array[i] - array[i - 1]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("The Max Profit by Selling Stock is: " + profitToSellStock(array));
    }
}
