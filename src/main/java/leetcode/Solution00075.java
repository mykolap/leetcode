package leetcode;

/**
 * 75. Sort Colors
 * <a href="https://leetcode.com/problems/sort-colors/">Web link</a>
 * Medium
 */

public class Solution00075 {

    public void sortColors(int[] nums) {
        int[] buckets = new int[3];
        for (int num : nums) {
            buckets[num]++;
        }
        int pos = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                nums[pos++] = i;
            }
        }
    }

}