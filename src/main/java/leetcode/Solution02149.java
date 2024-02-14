package leetcode;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * 2149. Rearrange Array Elements by Sign
 * Medium
 */
public class Solution02149 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int positiveIndex = 0;
        int negativeIndex = 1;
        for (int num : nums) {
            if (num >= 0) {
                result[positiveIndex] = num;
                positiveIndex += 2;
            } else {
                result[negativeIndex] = num;
                negativeIndex += 2;
            }
        }
        return result;
    }

}