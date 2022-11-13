package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class PrintEvenOrOdd {

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 5, 7, 9, 11, 24, 45);

        List<Integer> evenNumbers = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> oddNumbers = list.stream()
                .filter(e -> e % 2 != 0)
                .toList();

        System.out.println("Even Number is: " + evenNumbers);
        System.out.println("Odd Number is: " + oddNumbers);
    }
}
