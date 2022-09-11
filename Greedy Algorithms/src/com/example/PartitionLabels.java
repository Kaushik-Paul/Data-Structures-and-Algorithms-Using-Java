package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static List<Integer> getPartitions(String string) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> resultPartition = new ArrayList<>();
        // Populate the map with last occurrence of each character
        for (int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i), i);
        }

        int size = 0, end = 0;
        for (int i = 0; i < string.length(); i++) {
            size++;
            end = Math.max(end, map.get(string.charAt(i)));

            if (end == i) {
                resultPartition.add(size);
                size = 0;
            }
        }
        return resultPartition;
    }

    public static void main(String[] args) {
        String string = "ababcbacadefegdehijhklij";
        System.out.println("The Partition for this string is: " + getPartitions(string));
    }
}
