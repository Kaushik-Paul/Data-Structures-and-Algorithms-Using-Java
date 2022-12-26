package com.example;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    // O(n) time and O(n) space
    // Solution given by
    // https://www.youtube.com/watch?v=a-62yK1S1O4&ab_channel=happygirlzt
    public static String fractionToRecurringDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            stringBuilder.append("-");
        }
        long dividend = Math.abs(numerator);
        long divisor = Math.abs(denominator);
        long reminder = dividend % divisor;
        stringBuilder.append(dividend / divisor);

        if (reminder == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                stringBuilder.insert(map.get(reminder), "(");
                stringBuilder.append(")");
                break;
            }
            map.put(reminder, stringBuilder.length());
            reminder = reminder * 10;
            stringBuilder.append(reminder / divisor);
            reminder = reminder % divisor;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int numerator = 4;
        int denominator = 333;
        System.out.println("The Result of Division is: " + fractionToRecurringDecimal(numerator, denominator));
    }
}
