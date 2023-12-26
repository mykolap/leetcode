package leetcode.jumpGame;

/**
 * https://leetcode.com/problems/jump-game/
 * 55. Jump Game
 * <p>
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position. Determine if you are able to reach
 * the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104 0 <= nums[i] <= 105
 */
public class Solution0055 {

    // Time: O(n)
    // Space: O(1)
    public boolean canJump(int[] nums) {
        // Initialize the last reachable index to the last index.
        int lastReachableIndex = nums.length - 1;

        // Iterate over the array backwards.
        for (int i = nums.length - 1; i >= 0; i--) {
            // If the current index plus the value at the current index is greater than or equal to the last reachable
            // index, then the last reachable index is the current index.
            if (i + nums[i] >= lastReachableIndex) {
                lastReachableIndex = i;
            }
        }

        // Return whether the last reachable index is the first index.
        return lastReachableIndex == 0;
    }

    public boolean canJumpDirect(int[] nums) {
        int pos = 0;
        int remainingJumps = 0;
        while (pos < nums.length - 1) {
            int possibleJumps = Math.max(nums[pos], remainingJumps);
            if (possibleJumps <= 0) {
                return false;
            }
            remainingJumps = possibleJumps - 1;
            pos++;
        }
        return true;
    }

    public boolean canJumpBruteforce(int[] nums) {
        return canJumpFromPosition(nums, 0);
    }

    private boolean canJumpFromPosition(int[] nums, int i) {
        // If the current index is the last index, then return true.
        if (i == nums.length - 1) {
            return true;
        }

        // Iterate over the possible jump lengths.
        for (int j = 1; j <= nums[i]; j++) {
            // If the current index plus the jump length is less than the length of the array, then recursively call
            // canJumpFromPosition with the current index plus the jump length.
            if (i + j < nums.length) {
                if (canJumpFromPosition(nums, i + j)) {
                    return true;
                }
            }
        }

        // Return false.
        return false;
    }

}
