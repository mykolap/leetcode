/**
 * 2054. Two Best Non-Overlapping Events
 * <a href="https://leetcode.com/problems/two-best-non-overlapping-events">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution02054 {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int n = events.length;
        int[] maxValues = new int[n];
        maxValues[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            maxValues[i] = Math.max(maxValues[i - 1], events[i][2]);
        }

        int maxSum = 0;

        for (int[] event : events) {
            int start = event[0];
            int value = event[2];
            int idx = binarySearch(events, start - 1);
            int currentSum = value + (idx != -1 ? maxValues[idx] : 0);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    private int binarySearch(int[][] events, int targetEnd) {
        int start = 0;
        int end = events.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (events[mid][1] <= targetEnd) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }

}