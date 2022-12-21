package com.example;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    // O(3^n * 4^m) time and O(3^n * 4^m) space
    // where n is the number of digits that maps to 3 letters and m is the
    // number of digits that map to 4 letters
    public static List<String> letterCombinationOfPhoneNumber(String string) {
        LinkedList<String> outputList = new LinkedList<>();
        outputList.add("");
        String[] charMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < string.length(); i++) {
            int index = Character.getNumericValue(string.charAt(i));
            while (outputList.peek().length() == i) {
                String permutaion = outputList.remove();
                for (char ch : charMap[index].toCharArray()) {
                    outputList.add(permutaion + ch);
                }
            }
        }
        return outputList;
    }

    public static void main(String[] args) {
        String string = "23";
        System.out.println("The Letter Combination is: " + letterCombinationOfPhoneNumber(string));
    }
}
