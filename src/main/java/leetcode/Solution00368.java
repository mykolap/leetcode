package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 * 368. Largest Divisible Subset
 * Medium
 */
public class Solution00368 {

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int max = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[i] % nums[j] == 0) &&
                    (dp[j] + 1 > dp[i])) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while (index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }
        Collections.reverse(result);
        return result;
    }

}