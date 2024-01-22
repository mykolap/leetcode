package leetcode;

/**
 * 645. Set Mismatch
 * https://leetcode.com/problems/set-mismatch
 * <p>
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error,
 * one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and
 * loss of another number.
 * <p>
 * You are given an integer array nums representing the data status of this set after the error.
 * <p>
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^4
 */
public class Solution00645 {

    // Time: O(n)
    // Space: O(n)
    public int[] findErrorNums(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];

        int[] result = new int[2];
        for (int num : nums) {
            if (seen[num]) {
                result[0] = num;
            }
            seen[num] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!seen[i]) {
                result[1] = i;
                break;
            }
        }

        return result;
    }

}