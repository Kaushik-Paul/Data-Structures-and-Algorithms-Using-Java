package com.example;

public class SumOfTwoNumbers {

    // O(1) time and O(1) space
    // ** For large set of integer - O(n) time and O(1) space
     public static int sumOfTwoNumbers(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = a ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 5, b = 3;
        System.out.println("The Sum of Two Numbers are: " + sumOfTwoNumbers(a, b));
    }
}
