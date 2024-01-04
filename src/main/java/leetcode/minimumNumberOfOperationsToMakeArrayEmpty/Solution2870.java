package leetcode.minimumNumberOfOperationsToMakeArrayEmpty;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/">
 * 2870. Minimum Number of Operations to Make Array Empty
 * </a>
 * <p>
 * You are given a 0-indexed array nums consisting of positive integers.
 * <p>
 * There are two types of operations that you can apply on the array any number of times:
 * <p>
 * Choose two elements with equal values and delete them from the array.
 * Choose three elements with equal values and delete them from the array.
 * Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,3,2,2,4,2,3,4]
 * Output: 4
 * Explanation: We can apply the following operations to make the array empty:
 * - Apply the first operation on the elements at indices 0 and 3. The resulting array is nums = [3,3,2,4,2,3,4].
 * - Apply the first operation on the elements at indices 2 and 4. The resulting array is nums = [3,3,4,3,4].
 * - Apply the second operation on the elements at indices 0, 1, and 3. The resulting array is nums = [4,4].
 * - Apply the first operation on the elements at indices 0 and 1. The resulting array is nums = [].
 * It can be shown that we cannot make the array empty in less than 4 operations.
 * Example 2:
 * <p>
 * Input: nums = [2,1,2,2,3,3]
 * Output: -1
 * Explanation: It is impossible to empty the array.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Solution2870 {

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            } else {
                result += count / 3;
                int remainderOf3 = count % 3;
                if (remainderOf3 > 0) {
                    // remainderOf3 == 1
                    // step 1 not possible, but we can avoid removing 3, and remove 2 twice, so plus 1 step
                    // remainderOf3 == 2
                    // can remove 2, 1 step
                    result += 1;
                }
            }
        }
        return result;
    }

    public int minOperationsCeil(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            } else {
                result += Math.ceil((double) count / 3);
            }
        }
        return result;
    }

}
