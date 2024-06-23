package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * <a href="https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit">Web link</a>
 * Medium
 */

public class Solution01438 {

    public int longestSubarray(int[] nums, int limit) {
        int leftIndex = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        int maxDiff = 0;
        int n = nums.length;
        for (int rightIndex = 0; rightIndex < n; rightIndex++) {
            int right = nums[rightIndex];
            map.put(right, map.getOrDefault(right, 0) + 1);
            max = Math.max(max, right);
            min = Math.min(min, right);
            while (max - min > limit) {
                int left = nums[leftIndex];
                final int newLeftValue = map.get(left) - 1;
                if (newLeftValue == 0) {
                    map.remove(left);
                    if (map.isEmpty()) {
                        max = 0;
                        min = 0;
                    } else {
                        max = map.lastKey();
                        min = map.firstKey();
                    }
                } else {
                    map.put(left, newLeftValue);
                }
                leftIndex++;
            }
            maxDiff = Math.max(maxDiff, rightIndex - leftIndex + 1);
        }
        return maxDiff;
    }

    public int longestSubarrayOptimized(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int leftIndex = 0;
        int maxDiff = 0;
        int n = nums.length;
        for (int rightIndex = 0; rightIndex < n; rightIndex++) {
            int right = nums[rightIndex];
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < right) {
                maxQueue.pollLast();
            }
            while (!minQueue.isEmpty() && minQueue.peekLast() > right) {
                minQueue.pollLast();
            }
            maxQueue.add(right);
            int currentMax = maxQueue.peekFirst();
            minQueue.add(right);
            int currentMin = minQueue.peekFirst();
            if (currentMax - currentMin > limit) {
                final int left = nums[leftIndex];
                if (currentMax == left) {
                    maxQueue.pollFirst();
                }
                if (currentMin == left) {
                    minQueue.pollFirst();
                }
                leftIndex++;
            }
            maxDiff = Math.max(maxDiff, rightIndex - leftIndex + 1);
        }
        return maxDiff;
    }
}