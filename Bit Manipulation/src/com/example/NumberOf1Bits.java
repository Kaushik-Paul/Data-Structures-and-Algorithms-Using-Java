package com.example;

public class NumberOf1Bits {

    public static int numberOf1Bits(int num) {
        int count = 0;
        while (num > 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 00000000000000000000000000001011;
        System.out.println("The Number of 1 is: " + numberOf1Bits(num));
    }
}
