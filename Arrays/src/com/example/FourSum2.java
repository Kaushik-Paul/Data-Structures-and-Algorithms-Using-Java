package com.example;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

    // O(n^2) time and O(n^2) space
    public static int fourSum2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                int getCount = map.getOrDefault(-sum, 0);
                map.put(-sum, getCount + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                count += map.getOrDefault(sum, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{-2, -1};
        int[] num3 = new int[]{-1, 2};
        int[] num4 = new int[]{0, 2};

        System.out.println("Total Sum to get 0 are: " + fourSum2(num1, num2, num3, num4));
    }
}
