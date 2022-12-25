package com.example;

import java.util.Arrays;

public class GasStation {

    // O(n) time and O(1) space
    // Solution Given by NeetCode
    // https://www.youtube.com/watch?v=lJwbPZGo05A&ab_channel=NeetCode
    public static int getStartStation(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println("The Starting Station is: " + getStartStation(gas, cost));
    }
}
