package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * <a href="https://leetcode.com/problems/combination-sum-ii">Web link</a> |
 * Medium
 */

public class Solution00040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void findCombinations(int[] candidates, int target, int currentIndex, List<Integer> currentUsed, List<List<Integer>> result) {
        if (target == 0) {
            result.add(List.copyOf(currentUsed));
            return;
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            if (i > currentIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            currentUsed.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i + 1, currentUsed, result);
            currentUsed.removeLast();
        }
    }

}