package leetcode;

/**
 * 1052. Grumpy Bookstore Owner
 * https://leetcode.com/problems/grumpy-bookstore-owner/description/
 * Medium
 */

public class Solution01052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int i = 0;
        int curWin = 0;
        int maxWin = 0;

        for (int j = 0; j < n; j++) {
            curWin += customers[j] * grumpy[j];
            maxWin = Math.max(curWin, maxWin);
            if (j >= minutes - 1) {
                curWin -= customers[i] * grumpy[i++];
            }
        }
        int res = maxWin;
        for (i = 0; i < grumpy.length; i++) {
            res += customers[i] * (1 - grumpy[i]);
        }
        return res;
    }

    public int maxSatisfiedAlternative(int[] customers, int[] grumpy, int minutes) {
        final int n = customers.length;
        int guaranteedSatisfied = 0;
        int maxConditional = 0;
        int currentConditional = 0;
        int low = 0;
        for (int high = 0; high < n; high++) {
            if (grumpy[high] == 0) {
                guaranteedSatisfied += customers[high];
            } else {
                currentConditional += customers[high];
                while (high - low + 1 > minutes) {
                    if (grumpy[low] == 1) {
                        currentConditional -= customers[low];
                    }
                    low++;
                }
                maxConditional = Math.max(maxConditional, currentConditional);
            }
        }
        return guaranteedSatisfied + maxConditional;
    }

}