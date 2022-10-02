package com.example;

public class TypedOutStrings {

    // O(n) time and O(n) space
    private static String buildString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch != '#') {
                stringBuilder.append(ch);
            } else {
                if (stringBuilder.length() != 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static boolean compareStrings(String string1, String string2) {
        return buildString(string1).equals(buildString(string2));
    }

    public static void main(String[] args) {
        String string1 = "abc#d";
        String string2 = "abzz##d";

        System.out.println("Is Both the string equal: " + compareStrings(string1, string2));
    }
}
