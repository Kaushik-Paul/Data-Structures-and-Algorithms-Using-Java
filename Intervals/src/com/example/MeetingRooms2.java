package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRooms2 {

    private List<Interval> meetings;

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

    public MeetingRooms2() {
        meetings = new ArrayList<>();
    }

    public void addMeeting(int startTime, int endTime) {
        Interval interval = new Interval(startTime, endTime);
        meetings.add(interval);
    }

    // O(nlog n) time and O(n) space
    public int numberOfMeetingRooms() {
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();
        for (Interval interval : meetings) {
            startTimes.add(interval.startTime);
            endTimes.add(interval.endTime);
        }
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int start = 0, end = 0;
        int count = 0, result = 0;
        while (start < startTimes.size()) {
            if (startTimes.get(start) < endTimes.get(end)) {
                start++;
                count++;
            } else {
                end++;
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args) {
        MeetingRooms2 meetingRooms = new MeetingRooms2();
        meetingRooms.addMeeting(0, 30);
        meetingRooms.addMeeting(5, 10);
        meetingRooms.addMeeting(15, 20);
        System.out.println("The Number of Meeting Room required: " + meetingRooms.numberOfMeetingRooms());
    }
}
