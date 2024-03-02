package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 * <p>
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
 * you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]] Output: 1 Explanation: [1,3] can be removed and the rest of the
 * intervals are non-overlapping. Example 2:
 * <p>
 * Input: intervals = [[1,2],[1,2],[1,2]] Output: 2 Explanation: You need to remove two [1,2] to make the rest of the
 * intervals non-overlapping. Example 3:
 * <p>
 * Input: intervals = [[1,2],[2,3]] Output: 0 Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 2 * 104 intervals[i].length == 2 -2 * 104 <= starti < endi <= 2 * 104
 */
public class Solution00435 {

    // Time: O(n * log(n))
    // Space: O(1)
    public int eraseOverlapIntervalsSortByEnd(int[][] intervals) {
        // If the array is null or empty, return 0.
        if (intervals.length <= 1) {
            return 0;
        }

        // Sort the array by the end time of each interval.
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        // Initialize the number of intervals to remove to 0.
        int intervalsToRemove = 0;

        // Initialize the end time of the last interval to the end time of the first interval.
        int lastIntervalEnd = intervals[0][1];

        // Iterate over the array of intervals.
        for (int i = 1; i < intervals.length; i++) {
            // Get the current interval.
            int[] currentInterval = intervals[i];

            // If the start time of the current interval is less than or equal to the end time of the last interval,
            // increment the number of intervals to remove.
            if (currentInterval[0] < lastIntervalEnd) {
                intervalsToRemove++;
            } else {
                // Otherwise, update the end time of the last interval.
                lastIntervalEnd = currentInterval[1];
            }
        }

        // Return the number of intervals to remove.
        return intervalsToRemove;
    }

    // Time: O(n * log(n))
    // Space: O(1)
    public int eraseOverlapIntervalsSortByStart(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int lastIntervalEnd = intervals[0][1];
        int intervalsToRemove = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] >= lastIntervalEnd) {
                // non overlaping, update last interval
                lastIntervalEnd = currentInterval[1];
            } else {
                // as last - should be used the one with smaller end, so we have less overlaps
                // the one with bigger end - should be removed and not used as last
                if (currentInterval[1] < lastIntervalEnd) {
                    lastIntervalEnd = currentInterval[1];
                }
                intervalsToRemove++;
            }
        }

        return intervalsToRemove;
    }

}
