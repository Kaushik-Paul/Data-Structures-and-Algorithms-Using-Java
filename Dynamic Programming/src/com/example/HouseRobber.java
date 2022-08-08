package com.example;


public class HouseRobber {

    // 0(n) time and O(n) space
    public static int houseRobberWithArray(int[] loots) {
        int[] maxLoot = loots.clone();
        int maxProfit = Math.max(maxLoot[loots.length - 1], maxLoot[loots.length - 2]);
        for (int i = loots.length - 3; i >= 0; i--) {
            if ((maxLoot[i] + maxLoot[i + 2]) > maxProfit) {
                maxProfit = maxLoot[i] + maxLoot[i + 2];
                maxLoot[i] = maxProfit;
            }
        }
        return maxLoot[0];
    }


    public static void main(String[] args) {
        int[] loots = new int[]{1, 2, 3, 1};
        int[] loots2 = new int[]{2, 7, 9, 3, 1};
        System.out.println("The Maximum Loot the robber can rob is: " + houseRobberWithArray(loots2));

    }
}
