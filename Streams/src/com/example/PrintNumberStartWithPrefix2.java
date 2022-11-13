package com.example;

import java.util.List;

public class PrintNumberStartWithPrefix2 {

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 22, 45, 66, 276, -222, 866);
        List<Integer> result = list.stream()
                .map(e -> String.valueOf(e))
                .filter(e -> e.startsWith("2") || e.startsWith("-2"))
                .map(e -> Integer.valueOf(e))
                .toList();

        System.out.println("The Resultant list is: " + result);
    }
}
