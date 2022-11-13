package com.example;

import java.util.List;

public class SquareFilterAverage {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 10, 20, 30, 15);

        double averageResult = list.stream()
                .map(e -> e * e)
                .filter(e -> e > 100)
                .mapToInt(e -> e)
                .average().getAsDouble();

        System.out.println("the Result is: " + averageResult);

    }
}
