package com.example;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> getAllGroupAnagrams(String[] anagrams) {

        Map<String, List<String>> map = new HashMap<>();

        // Store in map
        for (String str : anagrams) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }

        List<List<String>> list = new ArrayList<>();
        map.forEach((key, value) -> list.add(value));
        return list;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"yo", "act", "flop", "tac", "act", "oy", "olfp"};
        System.out.println("All Group Anagrams are: " + getAllGroupAnagrams(strings));
    }
}
