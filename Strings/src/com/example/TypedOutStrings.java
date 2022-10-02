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

    // O(n) time and O(1) space
    public static boolean optimalBackspaceString(String string1, String string2) {
        int pointer1 = string1.length() - 1, pointer2 = string2.length() - 1;
        while (pointer1 >= 0 || pointer2 >= 0) {
            if (string1.charAt(pointer1) == '#' || string2.charAt(pointer2) == '#') {
                int backspace = 2;
                if (string1.charAt(pointer1) == '#') {
                    while (backspace > 0) {
                        if (pointer1 > 0) {
                            pointer1--;
                        }
                        backspace--;
                        if (string1.charAt(pointer1) == '#') {
                            backspace += 2;
                        }
                    }
                } else {
                    while (backspace > 0) {
                        if (pointer2 > 0) {
                            pointer2--;
                        }
                        backspace--;
                        if (string2.charAt(pointer2) == '#') {
                            backspace += 2;
                        }
                    }
                }
            } else {
                if (string1.charAt(pointer1) != string2.charAt(pointer2)) {
                    return false;
                } else {
                    pointer1--;
                    pointer2--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string1 = "abc#d";
        String string2 = "abzz##d";

        System.out.println("Is Both the string equal: " + optimalBackspaceString(string1, string2));
    }
}
