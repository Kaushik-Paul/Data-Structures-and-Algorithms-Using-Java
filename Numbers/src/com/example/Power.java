package com.example;

public class Power {

    // O(log x) time and O(1) space
    public static double getPowerOfNumber(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int num = Math.abs(n);
        int answer = 1;
        while (num > 0) {
            if (num % 2 == 1) {
                answer = answer * x;
                num = num - 1;
            } else {
                x = x * x;
                num = num / 2;
            }
        }
        return n > 0 ? answer : 1.0 / answer;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println("The Result is: " + getPowerOfNumber(x, n));
    }
}
