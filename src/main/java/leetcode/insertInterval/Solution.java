package leetcode.insertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 * 57. Insert Interval
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * <p>
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Example 3:
 * <p>
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 * <p>
 * Example 4:
 * <p>
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 * <p>
 * Example 5:
 * <p>
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals is sorted by intervals[i][0] in ascending order.
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 */
public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = new Solution().insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    // Time: O(n)
    // Space: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        if (newInterval[1] < intervals[0][0]) {
            int[][] result = new int[intervals.length + 1][2];
            result[0] = newInterval;
            System.arraycopy(intervals, 0, result, 1, intervals.length);
            return result;
        }
        if (newInterval[0] > intervals[intervals.length - 1][1]) {
            int[][] result = new int[intervals.length + 1][2];
            System.arraycopy(intervals, 0, result, 0, intervals.length);
            result[intervals.length] = newInterval;
            return result;
        }

        // Create an array to store the merged intervals.
        int[][] mergedIntervals = new int[intervals.length + 1][2];

        // Track the size of the merged intervals.
        int mergedIntervalsIndex = 0;

        for (int[] interval : intervals) {
            if (newInterval == null ||
                newInterval[0] > interval[1]) {
                mergedIntervals[mergedIntervalsIndex++] = interval;
            } else if (newInterval[1] < interval[0]) {
                mergedIntervals[mergedIntervalsIndex++] = newInterval;
                mergedIntervals[mergedIntervalsIndex++] = interval;
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (newInterval != null) {
            mergedIntervals[mergedIntervalsIndex++] = newInterval;
        }

        // Copy the merged intervals array to a smaller one if necessary.
        int[][] result = new int[mergedIntervalsIndex][2];
        System.arraycopy(mergedIntervals, 0, result, 0, mergedIntervalsIndex);

        // Return the merged intervals array.
        return result;
    }

}
