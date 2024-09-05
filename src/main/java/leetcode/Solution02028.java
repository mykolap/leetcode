package leetcode;

/**
 * 2028. Find Missing Observations
 * <a href="https://leetcode.com/problems/find-missing-observations">Web link</a> |
 * Medium
 */

public class Solution02028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int numRolls = rolls.length;
        int totalSum = mean * (n + numRolls);
        int observedSum = 0;

        // Calculate observed sum in a single loop
        for (int roll : rolls) {
            observedSum += roll;
        }

        int missingSum = totalSum - observedSum;

        // Check if the missing sum is within the valid range
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        int baseValue = missingSum / n;
        int extra = missingSum % n;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = baseValue + (i < extra ? 1 : 0);
        }

        return result;
    }

}