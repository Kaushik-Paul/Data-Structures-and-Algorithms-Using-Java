package com.example;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    // O(n) time and O(1) space
    // Similar to house robber approach
    // Using constraint
    public static int deleteAndEarn(int[] array) {
        int[] bucket = new int[10001];
        for (int num : array) {
            bucket[num] += num;
        }
        int[] maxEarn = new int[10001];
        maxEarn[0] = bucket[0];
        maxEarn[1] = bucket[1];
        for (int i = 2; i < bucket.length; i++) {
            maxEarn[i] = Math.max(maxEarn[i - 1], bucket[i] + maxEarn[i - 2]);
        }
        return maxEarn[10000];
    }

    // General Solution works in every constraint
    // O(n) time and O(n) space
    public static int deleteAndEarnV2(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        int earn1 = 0, earn2 = 0;
        for (int key : map.keySet()) {
            int currentEarn = map.get(key);
            // Can't use both currentEarn and earn2
            if (map.containsKey(key - 1)) {
                int temp = earn2;
                earn2 = Math.max(currentEarn + earn1, earn2);
                earn1 = temp;
            } else {
                // Can use both currentEarn and earn2
                int temp = earn2;
                earn2 = currentEarn + earn2;
                earn1 = temp;
            }
        }
        return earn2;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println("The Maximum Delete and Earn is: " + deleteAndEarnV2(array));
    }
}
