package com.example;

public class MaxProfitStocks {

    public static int maxProfit(int[] array) {
        // left is for buying and right is for selling
        int left = 0;
        int right = left + 1;
        int maxProfit = Integer.MIN_VALUE;
        while (right < array.length) {
            if (array[left] <= array[right]) {
                int profit = array[right] - array[left];
                maxProfit = Math.max(maxProfit, profit);
                right++;
            } else {
                left = right;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("The Maximum Profit In Stock is: " + maxProfit(array));
    }
}
