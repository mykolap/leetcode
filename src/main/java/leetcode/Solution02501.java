/**
 * 2501. Longest Square Streak in an Array
 * <a href="https://leetcode.com/problems/longest-square-streak-in-an-array">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution02501 {

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> mp = new HashMap<>();
        int result = -1;

        int previous = -1;
        for (int num : nums) {
            if (num == previous) {
                continue;
            }
            int sqrt = (int) Math.sqrt(num);

            if (sqrt * sqrt == num && mp.containsKey(sqrt)) {
                mp.put(num, mp.get(sqrt) + 1);
                result = Math.max(result, mp.get(num));
            } else {
                mp.put(num, 1);
            }
            previous = num;
        }

        return result;
    }

}