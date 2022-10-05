package com.example;

public class GCD {

    // O(min(num1, num2)) time and O(min(num1, num2)) space
    public static int findGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return findGCD(num2, num1 % num2);
    }

    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 25;
        System.out.println("The GCD of the numbers are: " + findGCD(num1, num2));
    }
}
