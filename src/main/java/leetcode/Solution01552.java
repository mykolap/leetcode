package leetcode;

import java.util.Arrays;

/**
 * 1552. Magnetic Force Between Two Balls
 * <a href="https://leetcode.com/problems/magnetic-force-between-two-balls">Web link</a> |
 * Medium
 */

public class Solution01552 {

    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int lo = 1;
        int hi = (position[n - 1] - position[0]) / (m - 1);
        int maxForce = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canPlaceBalls(position, m, mid)) {
                maxForce = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return maxForce;
    }

    private boolean canPlaceBalls(int[] position, int m, int mid) {
        int n = position.length;
        int balls = 1;
        int lastPosition = position[0];
        for (int i = 1; i < n; i++) {
            if (position[i] - lastPosition >= mid) {
                balls++;
                lastPosition = position[i];
            }
        }
        return balls >= m;
    }

}