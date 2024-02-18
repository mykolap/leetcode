package leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/
 * 3038. Maximum Number of Operations With the Same Score I
 * Easy
 */
public class Solution03038 {

    // Time: O(n)
    // Space: O(1)
    public int maxOperations(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int maxOperations = 1;
        int sum = nums[0] + nums[1];
        for (int i = 3; i < nums.length; i = i + 2) {
            if (nums[i - 1] + nums[i] == sum) {
                maxOperations++;
            } else {
                break;
            }
        }
        return maxOperations;
    }

}