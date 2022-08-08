package com.example;

public class BuySellStocks {

    public static int buyAndSellStocks(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        while (sell < prices.length) {
            if (prices[sell] > prices[buy]) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // important to note
                buy = sell;
            }
            sell++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 1, 4, 8, 7, 2, 5};
        int[] prices2 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("The Maximum Profit that can be gained is: " + buyAndSellStocks(prices));
    }
}
