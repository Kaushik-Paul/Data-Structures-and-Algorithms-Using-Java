package com.example;

import java.util.List;

public class LimitSum {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3);

        int first5 = list.stream().limit(5).reduce((p, q) -> p + q).get();
        List<Integer> skip5 = list.stream().skip(5).toList();
        System.out.println("Sum of first 5 number: " + first5);
        System.out.println("List after skipping first 5: " + skip5);
    }
}
