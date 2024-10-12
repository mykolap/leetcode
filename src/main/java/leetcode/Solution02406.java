package leetcode;

import java.util.Arrays;

/**
 * 2406. Divide Intervals Into Minimum Number of Groups
 * <a href="https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups">Web link</a> |
 * Medium
 */

public class Solution02406 {

    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int endPtr = 0;
        int groupCount = 0;

        for (int start : startTimes) {
            if (start > endTimes[endPtr]) {
                endPtr++;
            } else {
                groupCount++;
            }
        }

        return groupCount;
    }

}