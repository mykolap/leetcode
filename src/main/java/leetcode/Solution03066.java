package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 3066. Minimum Operations to Exceed Threshold Value II
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
 * Medium
 */
public class Solution03066 {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer((long) num);
        }
        int steps = 0;
        while (queue.peek() < k) {
            long first = queue.poll();
            long second = queue.poll();
            long amount = first * 2L + second;
            queue.offer(amount);
            steps++;
        }
        return steps;
    }

    public int minOperationsDraft(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int steps = 0;
        Queue<Long> queue = new ArrayDeque<>();
        int i = 0;
        while (i < n || !queue.isEmpty()) {
            long first;
            if (i == n) {
                first = queue.poll();
            } else {
                first = nums[i];
                if (!queue.isEmpty() && queue.peek() < first) {
                    first = queue.poll();
                } else {
                    i++;
                }
            }
            if (first >= k) {
                return steps;
            }
            long second;
            if (i == n) { // nothing left in main array for checking
                second = queue.poll();
            } else {
                second = nums[i];
                if (!queue.isEmpty() && queue.peek() < second) {
                    second = queue.poll();
                } else {
                    i++;
                }
            }
            long amount = Math.min(first, second) * 2L + Math.max(first, second);
            queue.offer(amount);
            steps++;
        }
        return steps;
    }
}
