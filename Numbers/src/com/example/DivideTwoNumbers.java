package com.example;

public class DivideTwoNumbers {

    // O(dividend) time and O(1) space
    // https://www.youtube.com/watch?v=6kFp_s_UtPE&ab_channel=TimothyHChang
    public static int divideTwoNumbers(int dividend, int divisor) {
        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);
        int output = 0;
        while (dividendAbs >= divisorAbs) {
            int temp = divisorAbs;
            int multiplier = 1;
            while (dividendAbs >= temp) {
                dividendAbs -= temp;
                temp += temp;
                output += multiplier;
                multiplier += multiplier;
            }
        }
        if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0)) {
            output = -output;
        }
        return output;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println("The Result of the division is: " + divideTwoNumbers(dividend, divisor));
    }
}
