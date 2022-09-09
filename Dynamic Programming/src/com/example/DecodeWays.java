package com.example;

public class DecodeWays {

    // O(n) time and O(n) space
    public static int decodeWays(String string) {

        int[] decodeWays = new int[string.length() + 1];
        decodeWays[0] = 1; // Base Case
        decodeWays[1] = string.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= string.length(); i++) {
            if (string.charAt(i - 2) != '0') {
                decodeWays[i] += decodeWays[i - 1];
            }
            if (string.charAt(i - 2) == '1' || (string.charAt(i - 2) == '2' && string.charAt(i - 1) < '7')) {
                decodeWays[i] += decodeWays[i - 2];
            }
        }
        return decodeWays[string.length()];
    }

    public static void main(String[] args) {
        String string = "226";
        System.out.println("The NUmber of ways to decode the sting is: " + decodeWays(string));
    }
}
