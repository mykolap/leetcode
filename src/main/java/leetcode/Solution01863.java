package leetcode;

/**
 * 1863. Sum of All Subset XOR Totals
 * <a href="https://leetcode.com/problems/sum-of-all-subset-xor-totals/">Web link</a>
 * Easy
 */

public class Solution01863 {

    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum |= num;
        }
        return sum << (n - 1);
    }

    public int subsetXORSumRecursion(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int total) {
        if (index == nums.length) {
            return total;
        }
        return dfs(nums, index + 1, total) + dfs(nums, index + 1, total ^ nums[index]);
    }

}