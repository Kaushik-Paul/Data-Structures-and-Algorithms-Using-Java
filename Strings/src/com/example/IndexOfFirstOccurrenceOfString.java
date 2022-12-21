package com.example;

public class IndexOfFirstOccurrenceOfString {

    // O(m*n) time and O(1) space
    public static int firstOccurrence(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("The index of first occurrence of the string is: " + firstOccurrence(haystack, needle));
    }
}
