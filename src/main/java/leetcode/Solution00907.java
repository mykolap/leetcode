package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 907. Sum of Subarray Minimums
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * #medium
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation:
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 * Example 2:
 * <p>
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */
public class Solution00907 {

    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;

        long[] left = new long[length];
        long[] right = new long[length];
        Arrays.fill(left, -1);
        Arrays.fill(right, length);

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        long result = 0;
        for (int i = 0; i < length; i++) {
            result += arr[i] * (i - left[i]) * (right[i] - i);
            result %= 1000000007;
        }
        return (int) result;
    }

}