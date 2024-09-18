package leetcode;

import java.util.Arrays;

/**
 * 179. Largest Number
 * <a href="https://leetcode.com/problems/largest-number">Web link</a> |
 * Medium
 */

public class Solution00179 {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strNums = new String[n];
        for (int i = 0; i < n; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        if (strNums[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }
        return sb.toString();
    }

}