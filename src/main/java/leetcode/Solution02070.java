/**
 * 2070. Most Beautiful Item for Each Query
 * <a href="https://leetcode.com/problems/most-beautiful-item-for-each-query">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution02070 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];

        // Sort and store max beauty
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int max = items[0][1];
        for (int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        for (int i = 0; i < queries.length; i++) {
            // answer i-th query
            ans[i] = binarySearch(items, queries[i]);
        }

        return ans;
    }

    private int binarySearch(int[][] items, int targetPrice) {
        int l = 0;
        int r = items.length - 1;
        int maxBeauty = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (items[mid][0] > targetPrice) {
                r = mid - 1;
            } else {
                // Found viable price. Keep moving to right
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                l = mid + 1;
            }
        }
        return maxBeauty;
    }

}