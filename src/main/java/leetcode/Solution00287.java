package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">
 * 287. Find the Duplicate Number
 * </a>
 * <br/>
 * <div class="content__u3I1 question-content__JfgR">
 * <div><p>Given an array of integers <code>nums</code> containing&nbsp;<code>n + 1</code> integers where each integer is in the range <code>[1, n]</code> inclusive.</p>
 *
 * <p>There is only <strong>one repeated number</strong> in <code>nums</code>, return <em>this&nbsp;repeated&nbsp;number</em>.</p>
 *
 * <p>You must solve the problem <strong>without</strong> modifying the array <code>nums</code>&nbsp;and uses only constant extra space.</p>
 *
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,4,2,2]
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [3,1,3,4,2]
 * <strong>Output:</strong> 3
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1]
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong>Example 4:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,2]
 * <strong>Output:</strong> 1
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */
public class Solution00287 {

    // Time: O(n^2)
    // Space: O(1)
    public int findDuplicateBruteforce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (current == nums[j]) {
                    return current;
                }
            }
        }

        return -1;
    }

    // Time: O(n)
    // Space: O(n)
    public int findDuplicateArray(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int num : nums) {
            if (visited[num]) {
                return num;
            }
            visited[num] = true;
        }

        return -1;
    }

    // Time: O(n)
    // Space: O(n)
    public int findDuplicateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }

            set.add(num);
        }

        return -1;
    }

    // Time: O(n)
    // Space: O(1)
    // Floyd's Tortoise and Hare (Cycle Detection), youtube https://www.youtube.com/watch?v=PvrxZaH_eZ4
    public int findDuplicateFloyd(int[] nums) {
        int slowPointer = nums[0];
        int fastPointer = nums[0];

        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        } while (slowPointer != fastPointer);

        slowPointer = nums[0];
        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }

        return slowPointer;
    }

}
