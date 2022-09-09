package com.example;

public class MinCostClimbingStairs {

    // O(n) time and O(n) space
    public static int minCostClimbingStairs(int[] array) {
        int[] minCost = array.clone();
        int topFloor = array.length;

        for (int i = minCost.length - 2; i >= 0; i--) {
            if (i + 2 == topFloor) {
                minCost[i] = Math.min(minCost[i] + minCost[i + 1], minCost[i]);
            } else {
                minCost[i] = Math.min(minCost[i] + minCost[i + 1], minCost[i] + minCost[i + 2]);
            }
        }
        return Math.min(minCost[0], minCost[1]);
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 20};
        int[] array2 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("The Minimum Cost for Climbing Stairs is: " + minCostClimbingStairs(array2));
    }
}
