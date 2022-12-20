package com.example;

public class PowerOfThree {

    // O(1) time and O(1) space
    // Solution provided from leetcode - https://leetcode.com/problems/power-of-three/solutions/77855/java-solution-without-hardcoding-or-recursion/
    public static boolean isPowerOfThree(int num) {
        double numerator = Math.log(num);
        double denominator = Math.log(3);
        int value = (int) Math.round(numerator / denominator);
        return Math.pow(3, value) == num;
    }

    public static void main(String[] args) {
        int num = 81;
        System.out.println("Is the number power of three: " + isPowerOfThree(num));
    }
}
