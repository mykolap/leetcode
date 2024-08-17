package leetcode;

import java.util.Arrays;

/**
 * 1937. Maximum Number of Points with Cost
 * <a href="https://leetcode.com/problems/maximum-number-of-points-with-cost">Web link</a>
 * Medium
 */
public class Solution01937 {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dpPrev = new long[n];
        for (int j = 0; j < n; j++) {
            dpPrev[j] = points[0][j];
        }
        long[] dpCurr = dpPrev;
        for (int i = 1; i < m; i++) {
            long[] leftMax = new long[n];
            leftMax[0] = dpPrev[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(dpPrev[j], leftMax[j - 1] - 1);
            }

            long[] rightMax = new long[n];
            rightMax[n - 1] = dpPrev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(dpPrev[j], rightMax[j + 1] - 1);
            }

            dpCurr = new long[n];
            for (int j = 0; j < n; j++) {
                dpCurr[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }

            dpPrev = dpCurr;
        }
        return Arrays.stream(dpCurr).max().getAsLong();
    }

    public long maxPoints_TLE(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dpPrev = new long[n];
        for (int j = 0; j < n; j++) {
            dpPrev[j] = points[0][j];
        }
        long[] dpCurr = dpPrev;
        for (int i = 1; i < m; i++) {
            int[] pointLine = points[i];
            dpCurr = new long[n];
            for (int j = 0; j < n; j++) {
                long currPoint = pointLine[j];
                for (int k = 0; k < n; k++) {
                    dpCurr[j] = Math.max(dpCurr[j], currPoint + dpPrev[k] - Math.abs(j - k));
                }
            }
            dpPrev = dpCurr;
        }
        return Arrays.stream(dpCurr).max().getAsLong();
    }

}