package com.example;

public class DecodeWays {

    // O(n) time and O(n) space
    public static int decodeWays(String string) {

        int[] decodeWays = new int[string.length() + 1];
        decodeWays[0] = 1; // Base Case
        decodeWays[1] = string.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= string.length(); i++) {
            if (string.charAt(i - 1) != '0') {
                decodeWays[i] += decodeWays[i - 1];
            }
            if (string.charAt(i - 2) == '1' || (string.charAt(i - 2) == '2' && string.charAt(i - 1) < '7')) {
                decodeWays[i] += decodeWays[i - 2];
            }
        }
        return decodeWays[string.length()];
    }

    // O(n) time and O(n) space
    public static int decodeWaysV2(String string) {
        int[] decodeWays = new int[string.length() + 1];
        // Base Case
        decodeWays[0] = 1;
        decodeWays[1] = string.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= string.length(); i++) {
            int oneDigit = Integer.parseInt(string.substring(i - 1, i));
            int twoDigit = Integer.parseInt(string.substring(i - 2, i));
            if (oneDigit >= 1) {
                decodeWays[i] += decodeWays[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                decodeWays[i] += decodeWays[i - 2];
            }
        }
        return decodeWays[string.length()];
    }

    public static void main(String[] args) {
        String string = "226";
        System.out.println("The Number of ways to decode the sting is: " + decodeWaysV2(string));
    }
}
