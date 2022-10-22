package com.example;

public class ReverseInteger {

    public static int reverseTheNumber(int x) {
        boolean isNegative = x < 0;

        x = Math.abs(x);
        int num = 0;

        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < num) {
                return 0;
            }

            num = 10 * num + x % 10;
            x /= 10;
        }

        return isNegative ? -num : num;
    }

    // O(n) time and O(1) space
    public static int reverseTheNumberV2(int num) {
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -1 * num;
        }

        long reversed = 0;
        while (num > 0) {
            reversed = (reversed * 10) + num % 10;
            num = num / 10;
        }
        return isNegative ? (int) (-1 * reversed) : (int) reversed;
    }

    public static void main(String[] args) {
        int num = -120;
        System.out.println("The Reverse of the Number is: " + reverseTheNumberV2(num));
    }
}
