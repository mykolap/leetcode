package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3264. Final Array State After K Multiplication Operations I
 * <a href="https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i">Web link</a>
 * Easy
 */

public class Solution03264 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        final Comparator<int[]> comparator = (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        for (int i = 0; i < k; i++) {
            int[] minPair = pq.poll();
            int value = minPair[0];
            int index = minPair[1];

            nums[index] = value * multiplier;

            pq.offer(new int[]{nums[index], index});
        }

        return nums;
    }

}