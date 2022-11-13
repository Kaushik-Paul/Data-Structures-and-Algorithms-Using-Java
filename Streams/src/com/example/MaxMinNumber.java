package com.example;

import java.util.Comparator;
import java.util.List;

public class MaxMinNumber {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3);

        Integer maxNumber = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        Integer minNumber = list.stream().min(Comparator.comparing(Integer::valueOf)).get();

        System.out.println("Maximum Number is: " + maxNumber);
        System.out.println("Minimum Number is: " + minNumber);

        // Method 2
        Integer maxNumber2 = list.stream().max((e1, e2) -> Integer.compare(e1, e2)).get();
        System.out.println("Maximum Number v2 is: " + maxNumber2);
    }
}
