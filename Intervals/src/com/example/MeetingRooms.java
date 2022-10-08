package com.example;

import java.util.ArrayList;
import java.util.List;

public class MeetingRooms {

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

    public MeetingRooms() {
        meetings = new ArrayList<>();
    }

    public void addMeeting(int startTime, int endTime) {
        Interval interval = new Interval(startTime, endTime);
        meetings.add(interval);
    }

    // O(nlog n) time and O(1) space
    public boolean canAttendMeeting() {
        meetings.sort((o1, o2) -> o1.startTime - o2.startTime);

        for (int i = 1; i < meetings.size(); i++) {
            Interval currentInterval = meetings.get(i);
            Interval previousInterval = meetings.get(i - 1);
            if (currentInterval.startTime < previousInterval.endTime) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        meetingRooms.addMeeting(5, 10);
        meetingRooms.addMeeting(15, 20);
        meetingRooms.addMeeting(0, 30);
        System.out.println("Can Attend Meetings: " + meetingRooms.canAttendMeeting());
    }
}
