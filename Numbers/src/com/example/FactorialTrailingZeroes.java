package com.example;

public class FactorialTrailingZeroes {

    // Solution submitted by - https://www.youtube.com/watch?v=nnmS7PEnvy8&ab_channel=TechBarik
    public static int numberOfTrailingZeroes(int num) {
        int count = 0;
        while (num > 0) {
            num /= 5;
            count += num;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 25;
        System.out.println("The Number of Trailing Zeroes are : " + numberOfTrailingZeroes(num));
    }
}
