package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    private final List<int[]> intervals;

    public MergeInterval() {
        intervals = new ArrayList<>();
    }

    public void addInterval(int startTime, int endTime) {
        intervals.add(new int[]{startTime, endTime});
    }

    // O(nlog n) time and O(n) space
    public void mergeIntervals() {
        intervals.sort((e1, e2) -> e1[0] - e2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            int lastStart = result.get(result.size() - 1)[0];
            int lastEnd = result.get(result.size() - 1)[1];
            if (intervals.get(i)[0] <= lastEnd) {
                result.set(result.size() - 1, new int[]{lastStart, Math.max(lastEnd, intervals.get(i)[1])});
            } else {
                result.add(intervals.get(i));
            }
        }

        printIntervals(result);
    }

    private void printIntervals(List<int[]> intervals) {
        intervals.forEach(e -> System.out.println(Arrays.toString(e)));
    }

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        mergeInterval.addInterval(1, 2);
        mergeInterval.addInterval(3, 5);
        mergeInterval.addInterval(4, 7);
        mergeInterval.addInterval(6, 8);
        mergeInterval.addInterval(9, 10);
        mergeInterval.mergeIntervals();
    }

}
