package leetcode;

import java.util.*;

/**
 * 2402. Meeting Rooms III
 * https://leetcode.com/problems/meeting-rooms-iii/
 * Hard
 */

public class Solution02402 {

    // Time: O(n * log(n))
    // Space: O(n)
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));

        PriorityQueue<MeetingData> currentMeetingData = new PriorityQueue<>(Comparator.comparingLong((MeetingData meetingData) -> meetingData.end).thenComparingInt(meetingData -> meetingData.index));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            availableRooms.offer(i);
        }

        Map<Integer, Integer> roomFrequency = new HashMap<>();

        int maxFrequencyRoom = 0;

        for (int[] meeting : meetings) {
            int meetingStart = meeting[0];
            int meetingEnd = meeting[1];

            while (!currentMeetingData.isEmpty() && currentMeetingData.peek().end <= meetingStart) {
                availableRooms.offer(currentMeetingData.poll().index);
            }

            int roomIndex;
            if (availableRooms.isEmpty()) {
                MeetingData meetingData = currentMeetingData.poll();
                roomIndex = meetingData.index;
                int duration = meetingEnd - meetingStart;
                currentMeetingData.offer(new MeetingData(meetingData.end + duration, roomIndex));
            } else {
                roomIndex = availableRooms.poll();
                currentMeetingData.offer(new MeetingData(meetingEnd, roomIndex));
            }

            roomFrequency.merge(roomIndex, 1, Integer::sum);
            int currentFrequency = roomFrequency.get(roomIndex);
            int maxFrequency = roomFrequency.getOrDefault(maxFrequencyRoom, Integer.MIN_VALUE);
            if (currentFrequency > maxFrequency) {
                maxFrequencyRoom = roomIndex;
            } else if (currentFrequency == maxFrequency) {
                maxFrequencyRoom = Math.min(roomIndex, maxFrequencyRoom);
            }
        }

        return maxFrequencyRoom;
    }

    private static class MeetingData {
        long end;
        int index;

        public MeetingData(long end, int index) {
            this.end = end;
            this.index = index;
        }
    }

    public int mostBooked2(int n, int[][] meetings) {
        // Sort meetings by start times
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));

        // Queue to keep track of available room numbers
        PriorityQueue<Integer> availableRoomsQueue = new PriorityQueue<>();

        // Queue to store MeetingData objects for each meeting, sorted by end times
        // If meeting's end time is the same, sort by smaller room number
        PriorityQueue<MeetingData> ongoingMeetingsQueue = new PriorityQueue<>(Comparator.comparingLong((MeetingData meetingData) -> meetingData.end).thenComparingInt(meetingData -> meetingData.index));

        // Array to track usage count of each room
        int[] roomUsageCount = new int[n];

        // Final result: room number with maximum usage - we will keep it updating
        int roomWithMaxUsage = 0;

        // Initially, all rooms are available
        for (int i = 0; i < n; i++) {
            availableRoomsQueue.offer(i);
        }

        // Processing: Iterate over each meeting interval
        for (int[] currentMeeting : meetings) {
            // Check if any room is available before scheduling next meeting
            while (!ongoingMeetingsQueue.isEmpty() && ongoingMeetingsQueue.peek().end <= currentMeeting[0]) {
                availableRoomsQueue.offer(ongoingMeetingsQueue.poll().index);
            }

            // Initialize 'latestPossibleStartTime' with currentMeeting[0]. We will see if there is a delay
            long latestPossibleStartTime = currentMeeting[0];

            // Check if there is delay due to non-availability of rooms
            if (availableRoomsQueue.isEmpty()) {
                // Pick the first ending meeting (or one of the such meetings with smaller room number)
                MeetingData firstEndingMeeting = ongoingMeetingsQueue.poll();
                latestPossibleStartTime = firstEndingMeeting.end;

                // Room number released by firstEndingMeeting
                availableRoomsQueue.offer(firstEndingMeeting.index);
            }

            // Now we have a room available - schedule the next meeting
            int assignedRoom = availableRoomsQueue.poll();
            roomUsageCount[assignedRoom]++;
            int meetingDuration = currentMeeting[1] - currentMeeting[0];
            ongoingMeetingsQueue.offer(new MeetingData(meetingDuration + latestPossibleStartTime, assignedRoom));

            // Update 'roomWithMaxUsage' with room number that holds maximum meetings
            if (roomUsageCount[assignedRoom] > roomUsageCount[roomWithMaxUsage]) {
                roomWithMaxUsage = assignedRoom;
            } else if (roomUsageCount[assignedRoom] == roomUsageCount[roomWithMaxUsage]) {
                roomWithMaxUsage = Math.min(roomWithMaxUsage, assignedRoom);
            }
        }
        return roomWithMaxUsage;
    }

}