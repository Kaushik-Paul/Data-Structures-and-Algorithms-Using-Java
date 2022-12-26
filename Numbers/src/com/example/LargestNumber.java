package com.example;

import java.util.Arrays;

public class LargestNumber {

    public static String largestNumber(int[] array) {
        String[] stringArray = new String[array.length];
        // Convert it into string array
        for (int i = 0; i < array.length; i++) {
            stringArray[i] = String.valueOf(array[i]);
        }
        Arrays.sort(stringArray, (o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));
        return String.join("", stringArray);
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 30, 34, 5, 9};
        System.out.println("The Largest Number is: " + largestNumber(array));
    }
}
