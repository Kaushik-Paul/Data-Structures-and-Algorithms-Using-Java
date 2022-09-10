package com.example;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    // O(n) time and O(n) space
    public static String encodeString(List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {
            stringBuilder.append(string.length()).append("#").append(string);
        }

        return stringBuilder.toString();
    }

    // O(n) time and O(n) space
    public static List<String> decodeString(String string) {
        List<String> decodedString = new ArrayList<>();

        int i = 0;
        while (i < string.length()) {
            int j = i;
            while (string.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(string.substring(i, j));
            decodedString.add(string.substring(j + 1, j + length + 1));
            i = j + 1 + length;
        }
        return decodedString;
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("leet");
        stringList.add("code");
        String encodedString = encodeString(stringList);
        System.out.println("Original String: " + stringList);
        System.out.println("The Encoded String is: " + encodedString);
        System.out.println("The Decoded String is: " + decodeString(encodedString));
    }
}
