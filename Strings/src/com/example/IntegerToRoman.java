package com.example;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {

    // O(n) time and O(1) space
    public static String integerToRoman(int num) {
        List<Object[]> sysList = new ArrayList<>();
        sysList.add(new Object[]{"I", 1});
        sysList.add(new Object[]{"IV", 4});
        sysList.add(new Object[]{"V", 5});
        sysList.add(new Object[]{"IX", 9});
        sysList.add(new Object[]{"X", 10});
        sysList.add(new Object[]{"XL", 40});
        sysList.add(new Object[]{"L", 50});
        sysList.add(new Object[]{"XC", 90});
        sysList.add(new Object[]{"C", 100});
        sysList.add(new Object[]{"CD", 400});
        sysList.add(new Object[]{"D", 500});
        sysList.add(new Object[]{"CM", 900});
        sysList.add(new Object[]{"M", 1000});

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = sysList.size() - 1; i >= 0; i--) {
            Object[] list = sysList.get(i);
            String symbol = (String) list[0];
            int value = (int) list[1];
            if (num / value > 0) {
                int count = num / value;
                stringBuilder.append(String.valueOf(symbol).repeat(Math.max(0, count)));
                num = num % value;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println("The Roman for the number is: " + integerToRoman(num));
    }
}
