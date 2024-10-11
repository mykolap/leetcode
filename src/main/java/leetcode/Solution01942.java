package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1942. The Number of the Smallest Unoccupied Chair
 * <a href="https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair">Web link</a> |
 * Medium
 */

public class Solution01942 {

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int targetArrival = times[targetFriend][0];

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int nextChair = 0;
        for (int[] time : times) {
            int arrival = time[0];
            int leave = time[1];

            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival) {
                availableChairs.add(leavingQueue.poll()[1]);
            }

            int chair;
            if (availableChairs.isEmpty()) {
                chair = nextChair++;
            } else {
                chair = availableChairs.poll();
            }

            leavingQueue.offer(new int[]{leave, chair});

            if (arrival == targetArrival) {
                return chair;
            }
        }

        return 0;
    }

}