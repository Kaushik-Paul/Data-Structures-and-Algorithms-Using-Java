package com.example;

import java.util.Arrays;
import java.util.List;

public class AverageOfNumbers {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        double average = list.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Average: " + average);
    }
}
