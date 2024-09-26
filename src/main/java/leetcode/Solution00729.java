package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. My Calendar I
 * <a href="https://leetcode.com/problems/my-calendar-i">Web link</a>
 * Medium
 */

public class Solution00729 {

    static class MyCalendar {

        private final List<int[]> bookings;

        public MyCalendar() {
            bookings = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] booking : bookings) {
                if (booking[0] < end && start < booking[1]) {
                    return false;
                }
            }
            bookings.add(new int[]{start, end});
            return true;
        }

    }

}