package com.example;

import java.util.Collections;
import java.util.List;

public class SortNumbers {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3);
        List<Integer> ascList = list.stream().sorted().toList();
        List<Integer> descList = list.stream().sorted(Collections.reverseOrder()).toList();
        System.out.println("Ascending List: " + ascList);
        System.out.println("Descending List: " + descList);
    }
}
