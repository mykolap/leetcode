package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 * <p>
 * Medium
 * <p>
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
 * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the
 * given input.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7 Output: [[2,2,3],[7]] Explanation: 2 and 3 are candidates, and 2 + 2 + 3 =
 * 7. Note that 2 can be used multiple times. 7 is a candidate, and 7 = 7. These are the only two combinations. Example
 * 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8 Output: [[2,2,2,2],[2,3,3],[3,5]] Example 3:
 * <p>
 * Input: candidates = [2], target = 1 Output: [] Example 4:
 * <p>
 * Input: candidates = [1], target = 1 Output: [[1]] Example 5:
 * <p>
 * Input: candidates = [1], target = 2 Output: [[1,1]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 30 1 <= candidates[i] <= 200 All elements of candidates are distinct. 1 <= target <= 500
 */
public class Solution00039 {

    // Time: O(n * 2^n)
    // Space: O(n * 2^n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, int index,
                                List<Integer> current,
                                List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        current.add(candidates[index]);
        combinationSum(candidates, target - candidates[index], index, current, result);

        current.remove(current.size() - 1);
        combinationSum(candidates, target, index + 1, current, result);
    }
}
