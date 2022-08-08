package com.example;

public class ClimbingStairs {

    // O(n) time and O(n) space
    public static int climbingStairsWithArray(int n) {
        int[] solution = new int[n + 1];
        solution[n] = 1;
        solution[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            solution[i] = solution[i + 1] + solution[i + 2];
        }
        return solution[0];
    }

    // O(n) time and O(1) space
    public static int climbingStairsWithoutArray(int n) {
        int first = 1;
        int second = 1;
        int result = 1;
        for (int i = n - 2; i >= 0; i--) {
            result = first + second;
            second = first;
            first = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("The number of ways to climb stairs is: " + climbingStairsWithArray(num));
        System.out.println("The number of ways to climb stairs is: " + climbingStairsWithoutArray(num));

    }
}
