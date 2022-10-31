package com.example;

import java.util.Arrays;

public class CountPrimes {

    // O(n) time and O(n) space
    public static int countPrimes(int num) {
        boolean[] isPrime = new boolean[num];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j < isPrime.length; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        int countPrime = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                countPrime++;
            }
        }
        return countPrime;
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println("The Number of Prime Numbers are: " + countPrimes(num));
    }
}
