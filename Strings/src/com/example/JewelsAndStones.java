package com.example;

public class JewelsAndStones {

    // O(m * n) time and O(1) space
    public static int numberOfJewels(String jewels, String stones) {
        int numberOfJewels = 0;
        for (int i = 0; i < jewels.length(); i++) {
            char jewel = jewels.charAt(i);
            for (int j = 0; j < stones.length(); j++) {
                char stone = stones.charAt(j);
                if (jewel == stone) {
                    numberOfJewels++;
                }
            }
        }
        return numberOfJewels;
    }

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println("The Number of Jewel present is: " + numberOfJewels(jewels, stones));
    }
}
