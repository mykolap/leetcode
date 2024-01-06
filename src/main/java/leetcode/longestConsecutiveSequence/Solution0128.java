package leetcode.longestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 128. Longest Consecutive Sequence
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Solution0128 {

    // Time: O(n)
    // Space: O(n)
    public int longestConsecutive(int[] nums) {
        // put all the numbers in the set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            // if num - 1 is not in the set, then num is the start of the sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int currentMax = 1;
                // find the end of the sequence
                while (set.contains(current + 1)) {
                    current++;
                    currentMax++;
                }
                // update the max
                max = Math.max(max, currentMax);
            }
            // if the max is greater than half of the array, then we can return the max
            if (max > nums.length / 2) {
                return max;
            }
        }
        return max;
    }

    // Time: O(n log n)
    // Space: O(1)
    public int longestConsecutiveSorting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int currentMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int prev = nums[i - 1];
            if (current == prev + 1) {
                currentMax++;
            } else if (current != prev) {
                max = Math.max(max, currentMax);
                currentMax = 1;
            }
        }
        return Math.max(max, currentMax);
    }

}
