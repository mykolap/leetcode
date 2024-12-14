/**
 * 2762. Continuous Subarrays
 * <a href="https://leetcode.com/problems/continuous-subarrays">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.SortedMap;
import java.util.TreeMap;

public class Solution02762 {

    public long continuousSubarrays(int[] nums) {
        long count = 0;
        int start = 0;
        SortedMap<Integer, Integer> hash = new TreeMap<>();
        for (int end = 0; end < nums.length; end++) {
            hash.put(nums[end], hash.getOrDefault(nums[end], 0) + 1);
            while (hash.lastKey() - hash.firstKey() > 2) {
                hash.put(nums[start], hash.get(nums[start]) - 1);
                if (hash.get(nums[start]) == 0) {
                    hash.remove(nums[start]);
                }
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }

}