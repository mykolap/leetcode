package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * Medium
 */
public class Solution00046 {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        return permute(numsList);
    }

    public List<List<Integer>> permute(List<Integer> numsList) {
        if (numsList.isEmpty()) {
            return List.of(List.of());
        }

        final int first = numsList.getFirst();
        List<List<Integer>> permuteNext = permute(numsList.subList(1, numsList.size()));
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> perm : permuteNext) {
            for (int i = 0; i <= perm.size(); i++) {
                List<Integer> newPerm = new ArrayList<>(perm);
                newPerm.add(i, first);
                result.add(newPerm);
            }
        }
        return result;
    }


}
