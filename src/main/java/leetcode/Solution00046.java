package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * <p>
 * Medium
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any
 * order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3] Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] Example 2:
 * <p>
 * Input: nums = [0,1] Output: [[0,1],[1,0]] Example 3:
 * <p>
 * Input: nums = [1] Output: [[1]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6 -10 <= nums[i] <= 10 All the integers of nums are unique.
 */
public class Solution00046 {

    // Time: O(n * n!)
    // Space: O(n * n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void permute(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i <= current.size(); i++) {
            current.add(i, nums[index]);
            permute(nums, index + 1, current, result);
            current.remove(i);
        }
    }

}
