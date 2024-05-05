package leetcode;

/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Medium
 */
public class Solution00152 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n + 1];
        int[] dpMin = new int[n + 1];
        dpMax[0] = 1;
        dpMin[0] = 1;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            int currentValue = nums[i];
            int maxAndValue = dpMax[i] * currentValue;
            int minAndValue = dpMin[i] * currentValue;
            int currentMax = Math.max(currentValue, Math.max(maxAndValue, minAndValue));
            int currentMin = Math.min(currentValue, Math.min(maxAndValue, minAndValue));
            max = Math.max(max, currentMax);
            dpMax[i + 1] = currentMax;
            dpMin[i + 1] = currentMin;
        }
        return max;
    }

    public int maxProductOptimized(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int maxSoFar = max;
        int minSoFar = max;
        for (int i = 1; i < n; i++) {
            int currentValue = nums[i];
            int maxAndValue = maxSoFar * currentValue;
            int minAndValue = minSoFar * currentValue;
            maxSoFar = Math.max(currentValue, Math.max(maxAndValue, minAndValue));
            minSoFar = Math.min(currentValue, Math.min(maxAndValue, minAndValue));
            max = Math.max(max, maxSoFar);
        }
        return max;
    }

}