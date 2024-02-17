package leetcode;

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
public class Solution00057 {

    // Time: O(n)
    // Space: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int currentIndex = 0;

        // Add all the intervals ending before newInterval starts
        while (currentIndex < intervals.length && intervals[currentIndex][1] < newInterval[0]) {
            result.add(intervals[currentIndex++]);
        }

        // Merge all overlapping intervals to one considering newInterval
        while (currentIndex < intervals.length && intervals[currentIndex][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[currentIndex][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[currentIndex][1]);
            currentIndex++;
        }
        result.add(newInterval); // Add the union of intervals we got

        // Add all the rest
        while (currentIndex < intervals.length) {
            result.add(intervals[currentIndex++]);
        }

        return result.toArray(new int[][]{});
    }

}
