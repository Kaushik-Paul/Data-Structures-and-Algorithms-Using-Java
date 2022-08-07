package com.example;

import java.util.HashMap;

public class FibonacciSequence {

    private HashMap<Integer, Integer> map;

    public FibonacciSequence() {
        map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 1);
    }

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 43
    public int getFibonacci(int pos) {
        if (map.containsKey(pos)) {
            return map.get(pos);
        }
        int tempValue = getFibonacci(pos - 1) + getFibonacci(pos - 2);
        map.put(pos, tempValue);
        return tempValue;
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        for (int i = 1; i <= 13; i++) {
            System.out.print(fibonacciSequence.getFibonacci(i) + " , ");
        }
    }
}
