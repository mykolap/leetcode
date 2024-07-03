package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * <a href="https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves">Web link</a>
 * Medium
 */

public class Solution01509 {

    public int minDifferenceSorting(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        for (int left = 0; left <= 3; left++) {
            int right = nums.length - 4 + left;
            minDifference = Math.min(minDifference, nums[right] - nums[left]);
        }
        return minDifference;
    }

    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (i < 4) {
                minHeap.offer(num);
                maxHeap.offer(num);
                continue;
            }

            if (num < minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }

            if (num > maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }

        int[] minValues = new int[4];
        int index = 3;
        while (!minHeap.isEmpty()) {
            minValues[index] = minHeap.poll();
            --index;
        }
        int[] maxValues = new int[4];
        index = 0;
        while (!maxHeap.isEmpty()) {
            maxValues[index] = maxHeap.poll();
            ++index;
        }

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minDifference = Math.min(minDifference, maxValues[i] - minValues[i]);
        }
        return minDifference;
    }

}