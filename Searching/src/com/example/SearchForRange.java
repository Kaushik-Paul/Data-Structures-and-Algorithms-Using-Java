package com.example;

import java.util.Arrays;

public class SearchForRange {

    // O(log(n)) time and O(1) space
    public static int[] searchForRange(int[] array, int target) {
        int[] range = new int[]{-1, -1};
        alteredBinarySearch(array, target, range, true);
        alteredBinarySearch(array, target, range, false);
        return range;
    }

    private static void alteredBinarySearch(int[] array, int target,int[] range, boolean goLeft) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                if (goLeft) {
                    if (mid == 0 || array[mid - 1] != target) {
                        range[0] = mid;
                        break;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == array.length - 1 || array[mid + 1] != target) {
                        range[1] = mid;
                        break;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73};
        int target = 45;
        int[] range = searchForRange(array, target);
        System.out.println("The Range of the element is: " + Arrays.toString(range));
    }
}
