package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. My Calendar II
 * <a href="https://leetcode.com/problems/my-calendar-ii">Web link</a>
 * Medium
 */

public class Solution00731 {

    static class MyCalendarTwo {

        private final List<int[]> nonOverlappingBookings;
        private final List<int[]> overlappingBookings;

        public MyCalendarTwo() {
            nonOverlappingBookings = new ArrayList<>();
            overlappingBookings = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] booking : overlappingBookings) {
                if (booking[0] < end && start < booking[1]) {
                    return false;
                }
            }

            for (int[] booking : nonOverlappingBookings) {
                if (booking[0] < end && start < booking[1]) {
                    overlappingBookings.add(new int[]{
                            Math.max(start, booking[0]),
                            Math.min(end, booking[1])
                    });
                }
            }

            nonOverlappingBookings.add(new int[]{start, end});
            return true;
        }

    }

}