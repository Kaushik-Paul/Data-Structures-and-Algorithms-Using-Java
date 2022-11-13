package com.example;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDuplicateNumbers {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 30, 19, 3);

        // Method 1
        Set<Integer> duplicateNumbers = list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.toSet());
        System.out.println("Duplicate Numbers: " + duplicateNumbers);

        // Method 2
        Set<Integer> dummySet = new HashSet<>();
        Set<Integer> duplicateNumbers2 = list.stream().filter(e -> !dummySet.add(e)).collect(Collectors.toSet());
        System.out.println("Duplicate Numbers v2: " + duplicateNumbers);
    }
}
