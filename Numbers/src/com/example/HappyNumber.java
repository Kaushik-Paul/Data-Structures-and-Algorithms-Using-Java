package com.example;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappyNumber(int num) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(num)) {
            if (num == 1) {
                return true;
            }
            set.add(num);
            num = getSquareOfDigits(num);
        }
        return false;
    }

    private static int getSquareOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int temp = num % 10;
            num = num / 10;
            sum += (temp * temp);
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 19;
        System.out.println("Is the Number happy: " + isHappyNumber(num));
    }
}
