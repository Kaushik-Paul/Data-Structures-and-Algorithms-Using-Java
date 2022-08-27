package com.example;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static List<List<Integer>> powerSet(int[] array) {
        List<List<Integer>> subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());
        for (int num : array) {
            for (int i = 0; i < subSets.size(); i++) {
                List<Integer> currentSubset = subSets.get(i);
                currentSubset.add(num);
                subSets.add(currentSubset);
            }
        }

        System.out.println(subSets);
        return subSets;
    }

    public static void main(String[] args) {
        powerSet(new int[]{2,4});
    }

}
