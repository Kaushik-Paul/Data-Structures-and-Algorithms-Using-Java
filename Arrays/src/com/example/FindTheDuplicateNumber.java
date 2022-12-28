package com.example;

public class FindTheDuplicateNumber {

    // O(n) time and O(1) space
    // Used hare-tortoise method to solve
    // https://www.youtube.com/watch?v=32Ll35mhWg0&ab_channel=takeUforward
    public static int findTheDuplicateNumber(int[] array) {
        int slow = array[0];
        int fast = array[0];
        do {
            slow = array[slow];
            fast = array[array[fast]];
        } while (slow != fast);
        slow = array[0];
        while (slow != fast) {
            slow = array[slow];
            fast = array[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 3, 4, 2};
        System.out.println("The Duplicate Number is: " + findTheDuplicateNumber(array));
    }
}
