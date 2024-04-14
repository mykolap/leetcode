package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3111. Minimum Rectangles to Cover Points
 * https://leetcode.com/problems/minimum-rectangles-to-cover-points/
 * Medium
 */
public class Solution03111 {

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        final int n = points.length;
        int rectCount = 1;
        int lastX = points[0][0] + w;
        for (int i = 1; i < n; i++) {
            int x = points[i][0];
            if (x > lastX) {
                rectCount++;
                lastX = x + w;
            }
        }
        return rectCount;
    }

}
