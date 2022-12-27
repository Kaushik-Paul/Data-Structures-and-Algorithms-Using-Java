package com.example;

import java.util.Arrays;

public class PerfectSquare {

    // O(n * n^1/2) time and O(n) space
    public static int getMiniMumOfPerfectSquare(int num) {
        int[] dp = new int[num + 1];
        Arrays.fill(dp, num);
        dp[0] = 0;

        for (int target = 1; target <= num; target++) {
            for (int s = 1; s <= target; s++) {
                int square = s * s;
                if (target < square) {
                    break;
                }
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);
            }
        }
        return dp[num];
    }

    public static void main(String[] args) {
        int num = 12;
        System.out.println("The Minimum Number of Perfect Square required is: " + getMiniMumOfPerfectSquare(num));
    }
}
