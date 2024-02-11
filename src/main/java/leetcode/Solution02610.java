package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 * 2610. Convert an Array Into a 2D Array With Conditions
 *
 */
public class Solution02610 {

    // Time: O(n)
    // Space: O(n)
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            final int currentFrequency = map.getOrDefault(num, 0);
            if (currentFrequency >= result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(currentFrequency).add(num);
            map.put(num, currentFrequency + 1);
        }

        return result;
    }
}
