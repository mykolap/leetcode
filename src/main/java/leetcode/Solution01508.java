package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1508. Range Sum of Sorted Subarray Sums
 * <a href="https://leetcode.com/problems/range-sum-of-sorted-subarray-sums">Web link</a> |
 * Medium
 */

public class Solution01508 {

    final static int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> subarraySums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sum %= MOD;
                subarraySums.add(sum);
            }
        }

        subarraySums.sort(null);

        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result += subarraySums.get(i);
            result %= MOD;
        }
        return (int) result;
    }

    public int rangeSumMinHeap(int[] nums, int n, int left, int right) {
        PriorityQueue<Data> minHeap = new PriorityQueue<>(Comparator.comparingLong(Data::sum));
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Data(nums[i], i));
        }

        long result = 0;
        for (int i = 1; i <= right; i++) {
            Data data = minHeap.poll();
            if (i >= left) {
                result += data.sum();
                result %= MOD;
            }
            if (data.index() < n - 1) {
                int newIndex = data.index() + 1;
                long newSum = data.sum() + nums[newIndex];
                newSum %= MOD;
                Data newData = new Data(newSum, newIndex);
                minHeap.offer(newData);
            }
        }
        return (int) result;
    }

    private record Data(long sum, int index) {
    }

}