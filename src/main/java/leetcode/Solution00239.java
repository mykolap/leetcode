package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 239. Sliding Window Maximum
 * <p>
 * You are given an array of integers nums,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7        3
 * 1  3 [-1  -3  5] 3  6  7        5
 * 1  3  -1 [-3  5  3] 6  7        5
 * 1  3  -1  -3 [5  3  6] 7        6
 * 1  3  -1  -3  5 [3  6  7]       7
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 * <p>
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * Example 4:
 * <p>
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * Example 5:
 * <p>
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class Solution00239 {

    // Time: O(n)
    // Space: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int numsLength = nums.length;
        // Create an array to store the maximum values of the sliding window.
        int[] result = new int[numsLength - k + 1];
        // Create a queue to store the indices of the numbers in the sliding window.
        int[] queue = new int[numsLength];
        // Create a pointer to keep track of the index of the first element in the queue.
        int front = 0;
        // Create a pointer to keep track of the index of the last element in the queue.
        int rear = -1;

        // Iterate over the numbers in the array nums.
        for (int i = 0; i < numsLength; i++) {
            // If the queue is not empty and the index of the first element in the queue is outside of the sliding window,
            // remove the first element from the queue.
            if (front <= rear && i - queue[front] >= k) {
                front++;
            }

            // While the queue is not empty and the number at the index of the last element in the queue is less than
            // the current number, remove the last element from the queue.
            while (front <= rear && nums[queue[rear]] < nums[i]) {
                rear--;
            }

            // Add the index of the current number to the queue.
            queue[++rear] = i;

            // If the index of the first element in the queue is within the sliding window,
            // add the number at the index of the first element in the queue to the array result.
            final int resultIndex = i - k + 1;
            if (resultIndex >= 0) {
                result[resultIndex] = nums[queue[front]];
            }
        }

        // Return the array result.
        return result;
    }

    // Time: O(n)
    // Space: O(n)
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        // Create an array to store the maximum values of the sliding window.
        final int numsLength = nums.length;
        int[] result = new int[numsLength - k + 1];
        // Create a deque to store the indices of the numbers in the sliding window.
        Deque<Integer> deque = new ArrayDeque<>();

        // Iterate over the numbers in the array nums.
        for (int i = 0; i < numsLength; i++) {
            // If the deque is not empty and the index of the first element in the deque is outside of the sliding window,
            // remove the first element from the deque.
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            // While the deque is not empty and the number at the index of the last element in the deque is less than
            // the current number, remove the last element from the deque.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the index of the current number to the deque.
            deque.offerLast(i);

            // If the index of the first element in the deque is within the sliding window,
            // add the number at the index of the first element in the deque to the array result.
            final int resultIndex = i - k + 1;
            if (resultIndex >= 0) {
                result[resultIndex] = nums[deque.peekFirst()];
            }
        }

        // Return the array result.
        return result;
    }

}

