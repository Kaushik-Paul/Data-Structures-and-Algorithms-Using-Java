package com.example;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // O(n) time and O(1) space
    public static int romanToInteger(String string) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;

        for (int i = 0; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            if (i + 1 < string.length() && roman.get(currentCharacter) < roman.get(string.charAt(i + 1))) {
                result -= roman.get(currentCharacter);
            } else {
                result += roman.get(currentCharacter);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "LVIII";
        System.out.println("The Integer for the roman is: " + romanToInteger(string));
    }
}
