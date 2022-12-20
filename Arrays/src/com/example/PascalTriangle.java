package com.example;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // O(n^2) time and O(n^2) space
    public static List<List<Integer>> pascalTriangle(int num) {
        List<List<Integer>> resultTriangle = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(j, 1);
                } else {
                    List<Integer> getPreviousList = resultTriangle.get(i - 1);
                    list.add(getPreviousList.get(j - 1) + getPreviousList.get(j));
                }
            }
            resultTriangle.add(list);
        }
        return resultTriangle;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("The Pascal's Triangle is: " + pascalTriangle(num));
    }
}
