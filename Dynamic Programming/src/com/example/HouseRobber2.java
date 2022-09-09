package com.example;

import java.util.Arrays;

public class HouseRobber2 {

    public static int houseRobber2(int[] array) {
        return Math.max(houseRobberHelper(Arrays.copyOfRange(array, 0, array.length - 1)), houseRobberHelper(Arrays.copyOfRange(array, 1, array.length)));
    }

    private static int houseRobberHelper(int[] array) {
        int first = array[array.length - 1];
        int second = Math.max(array[array.length - 2], first);

        for (int i = array.length - 3; i >= 0; i--) {
            array[i] = Math.max(array[i] + first, second);
            first = array[i + 1];
            second = array[i];
        }
        return array[0];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 1};
        int[] array2 = new int[]{2, 3, 2};

        System.out.println("The Max Loot that the robber can do: " + houseRobber2(array));
    }

}
