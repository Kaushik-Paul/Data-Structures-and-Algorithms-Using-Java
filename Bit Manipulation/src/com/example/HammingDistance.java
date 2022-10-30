package com.example;

public class HammingDistance {

    // O(n + m) time and O(1) space
    public static int hammingDistance(int num1, int num2) {
        int result = 0;
        while (num1 > 0 || num2 > 0) {
            result += (num1 % 2) ^ (num2 % 2);
            num1 = num1 / 2;
            num2 = num2 / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 4;
        System.out.println("The Hamming Distance between two number is: " + hammingDistance(num1, num2));
    }
}
