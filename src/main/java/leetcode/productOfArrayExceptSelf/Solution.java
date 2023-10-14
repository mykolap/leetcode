package leetcode.productOfArrayExceptSelf;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up:
 *
 * Could you solve it in O(n) time complexity and without using division?
 * Could you solve it with O(1) constant space complexity? (The output array does not count as extra space
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] result = new Solution().productExceptSelf(nums);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // Time: O(n)
    // Space: O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // product of all elements to the left of i
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        // product of all elements to the right of i
        int rightProducts = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProducts *= nums[i+1];
            result[i] *= rightProducts; // multiply products to the left by the product to the right
        }

        return result;
    }

}
