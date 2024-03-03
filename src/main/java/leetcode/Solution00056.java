package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 56. Merge Intervals
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals,
 * and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * <p>
 * Explanation: Since intervals [1,3] and [2,6] overlaps,
 * merge them into [1,6].
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * <p>
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 */
public class Solution00056 {

    // Time: O(n * log(n))
    // Space: O(n)
    public int[][] merge(int[][] intervals) {
        // If the array is null or empty, return null.
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the array by the start time of each interval.
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // Create a list to store the merged intervals.
        List<int[]> mergedIntervals = new ArrayList<>(intervals.length);

        // Add the first interval to the list.
        int[] lastInterval = intervals[0];
        mergedIntervals.add(lastInterval);

        // Iterate over the array of intervals.
        for (int i = 1; i < intervals.length; i++) {
            // Get the current interval.
            int[] currentInterval = intervals[i];

            // If the start time of the current interval is less than or equal to the end time of the last interval,
            // merge the intervals.
            if (currentInterval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                // Otherwise, add the current interval to the list.
                lastInterval = currentInterval;
                mergedIntervals.add(currentInterval);
            }
        }

        // Return the list as an array.
        return mergedIntervals.toArray(new int[][]{});
    }

}

