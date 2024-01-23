package leetcode;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 * #medium
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * Follow up:
 * <p>
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class Solution00189 {

    /**
     * 1. Brute force
     * Time complexity: O(n*k)
     * Space complexity: O(1)
     */
    public void rotateBruteforce(int[] nums, int k) {
        // Get the length of the array
        int n = nums.length;

        // Calculate the effective rotation steps, as k could be larger than n
        k %= n;

        // If no rotation is needed, return immediately
        if (k == 0) {
            return;
        }

        // Create a temporary array to hold the last k elements of the original array
        int[] tmp = new int[k];

        // Copy the last k elements from the original array to the temporary array
        System.arraycopy(nums, n - k, tmp, 0, k);

        // Shift the first n-k elements of the original array to the right by k positions
        System.arraycopy(nums, 0, nums, k, n - k);

        // Copy the temporary array (which holds the original last k elements) to the beginning of the array
        System.arraycopy(tmp, 0, nums, 0, k);
    }

    /**
     * 2. Cyclic replacement
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public void rotateCyclicReplacement(int[] nums, int k) {
        // Get the length of the array
        int n = nums.length;

        // Calculate the effective rotation steps, as k could be larger than n
        k %= n;

        // If no rotation is needed, return immediately
        if (k == 0) {
            return;
        }

        // Initialize a counter to keep track of the number of elements that have been moved
        int count = 0;

        // Iterate over the array, starting from the first element
        for (int startIndex = 0; count < n; startIndex++) {
            // Initialize the currentTargetIndex index and the value to be moved
            int currentTargetIndex = startIndex;
            int prevValue = nums[startIndex];

            // Keep moving the values in the array until we return to the startIndex index
            do {
                // Calculate the index of the nextTargetIndex value to be moved
                int nextTargetIndex = (currentTargetIndex + k) % n;

                // Swap the nextTargetIndex value with the previous value
                int tmp = nums[nextTargetIndex];
                nums[nextTargetIndex] = prevValue;
                prevValue = tmp;

                // Update the currentTargetIndex index and increment the counter
                currentTargetIndex = nextTargetIndex;
                count++;
            } while (startIndex != currentTargetIndex); // Continue until we have moved all n elements
        }
    }

}