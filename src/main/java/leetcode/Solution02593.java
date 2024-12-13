/**
 * 2593. Find Score of an Array After Marking All Elements
 * <a href="https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution02593 {

    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        Set<Integer> set = new HashSet<>();
        long score = 0;

        for (int[] a : arr) {
            int val = a[0];
            int idx = a[1];

            if (set.add(idx)) {
                score += val;
                set.add(idx + 1);
                set.add(idx - 1);
            }
        }
        return score;
    }

}