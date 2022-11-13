package com.example;

import java.util.Collections;
import java.util.List;

public class SecondHighestLowest {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3);

        Integer secondHighest = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
        Integer secondLowest = list.stream().sorted().distinct().skip(1).findFirst().get();
        System.out.println("Second Highest: " + secondHighest);
        System.out.println("Second Lowest: " + secondLowest);

    }
}
