package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 539. Minimum Time Difference
 * <a href="https://leetcode.com/problems/minimum-time-difference">Web link</a>
 * Medium
 */

public class Solution00539 {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        int i = 0;
        for (String time : timePoints) {
            String[] parts = time.split(":");
            minutes[i++] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
        Arrays.sort(minutes);
        int minDiff = minDistance(minutes[0], minutes[n - 1]);
        for (i = 1; i < n; i++) {
            if (minutes[i] == minutes[i - 1]) {
                return 0;
            } else {
                minDiff = Math.min(minDiff, minDistance(minutes[i], minutes[i - 1]));
            }
        }
        return minDiff;
    }

    private int minDistance(int minute1, int minute2) {
        if (minute1 < minute2) {
            return minDistance(minute2, minute1);
        }
        return Math.min(minute1 - minute2, 1440 - (minute1 - minute2));
    }

}