package com.example;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    private List<Interval> intervals;

    private class Interval {
        int startTime;
        int endTime;

        public Interval(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }

        public Interval() {
        }


        @Override
        public String toString() {
            return "Interval{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

    public InsertInterval() {
        intervals = new ArrayList<>();
    }

    public void addMeeting(int startTime, int endTime) {
        Interval interval = new Interval(startTime, endTime);
        intervals.add(interval);
    }

    // O(nlog n) time and O(n) space
    public void insertInterval(int startNewInterval, int endNewInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        // Continue adding until merge
        while (i < intervals.size() && startNewInterval > intervals.get(i).endTime) {
            result.add(intervals.get(i++));
        }
        // Make new interval to merge
        while (i < intervals.size() && endNewInterval >= intervals.get(i).startTime) {
            startNewInterval = Math.min(startNewInterval, intervals.get(i).startTime);
            endNewInterval = Math.max(endNewInterval, intervals.get(i).endTime);
            i++;
        }
        result.add(new Interval(startNewInterval, endNewInterval));
        // Add the remaining intervals
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }

        printInterval(result);
    }

    public void printInterval(List<Interval> intervals) {
        System.out.println("Intervals are: " + intervals);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        insertInterval.addMeeting(1, 2);
        insertInterval.addMeeting(3, 5);
        insertInterval.addMeeting(6, 7);
        insertInterval.addMeeting(8, 10);
        insertInterval.addMeeting(12, 16);
        insertInterval.insertInterval(4, 8);
    }
}
