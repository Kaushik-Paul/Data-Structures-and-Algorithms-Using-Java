package com.example;

public class ExcelSheetColumnNumber {

    // O(n) time and O(1) space
    public static int getColumnNumber(String string) {
        int result = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            char ch = string.charAt(i);
            int num = ch - 'A' + 1;
            result += result * 26 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "ZY";
        System.out.println("The Column Number is: " + getColumnNumber(string));
    }
}
