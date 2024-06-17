package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 633. Sum of Square Numbers
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 * Medium
 */

public class Solution00633 {

    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= max; i++) {
            final int power = i * i;
            set.add(power);
            int remainingPower = c - power;
            if (set.contains(remainingPower)) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSumOptimized(int c) {
        int max = (int) Math.sqrt(c);
        int start = 0;
        long powerStart = 0;
        int end = max;
        long powerEnd = (long) end * end;
        while (start <= end) {
            long sum = powerStart + powerEnd;
            if (sum < c) {
                start++;
                powerStart = (long) start * start;
            } else if (sum > c) {
                end--;
                powerEnd = (long) end * end;
            } else {
                return true;
            }
        }
        return false;
    }

}