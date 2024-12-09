/**
 * 3152. Special Array II
 * <a href="https://leetcode.com/problems/special-array-ii">Web link</a>
 * Medium
 */

package leetcode;

public class Solution03152 {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] cum = new int[n];
        boolean[] ans = new boolean[queries.length];

        for (int i = 1; i < n; i++) {
            cum[i] = cum[i - 1];
            if (nums[i] % 2 == nums[i - 1] % 2) {
                cum[i]++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = query[0];
            int y = query[1];
            int falseCount = cum[y] - (x > 0 ? cum[x] : 0);
            if (falseCount <= 0 || x == y) {
                ans[i] = true;
            }
        }

        return ans;
    }

}