package com.example;

import java.util.List;

public class SumOfNumbers {

    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40, 50, 60);
        Integer integer = list.stream().reduce((a, b) -> a + b).get();
        System.out.println(integer);
    }
}
