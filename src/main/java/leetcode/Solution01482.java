package leetcode;

/**
 * 1482. Minimum Number of Days to Make m Bouquets
 * <a href="https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets">Web link</a> |
 * Medium
 */

public class Solution01482 {

    public int minDays(int[] bloomDay, int m, int k) {
        final int n = bloomDay.length;
        if (n < (long) m * k) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int mid) {
        int bouquets = 0;
        int flowers = 0;
        for (int day : bloomDay) {
            if (day <= mid) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    if (bouquets >= m) {
                        return true;
                    }
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return false;
    }

}