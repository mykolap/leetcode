package leetcode;

import java.util.*;

/**
 * 2597. The Number of Beautiful Subsets
 * <a href="https://leetcode.com/problems/the-number-of-beautiful-subsets">Web link</a> |
 * Medium
 */

public class Solution02597 {
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Map<Integer, Integer>> groups = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int num : count.keySet()) {
            if (visited.contains(num))
                continue;
            Map<Integer, Integer> group = new HashMap<>();
            while (count.containsKey(num - k)) {
                num -= k;
            }
            while (count.containsKey(num)) {
                group.put(num, count.get(num));
                visited.add(num);
                num += k;
            }
            groups.add(group);
        }

        int result = 1;

        for (Map<Integer, Integer> group : groups) {
            int min = group.keySet().stream().min(Integer::compareTo).orElse(0);
            result *= calculateSubsetCombinations(min, k, group);
        }

        return result - 1;
    }

    private int calculateSubsetCombinations(int min, int k, Map<Integer, Integer> group) {
        if (!group.containsKey(min)) {
            return 1;
        }
        int skip = calculateSubsetCombinations(min + k, k, group);
        int include = ((int) Math.pow(2, group.get(min)) - 1) * calculateSubsetCombinations(min + 2 * k, k, group);
        return skip + include;
    }

}