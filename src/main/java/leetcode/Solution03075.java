package leetcode;

import java.util.Arrays;

/**
 * 3075. Maximize Happiness of Selected Children
 * https://leetcode.com/problems/maximize-happiness-of-selected-children/description/
 * Medium
 */

public class Solution03075 {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        int numberToDecrease = 0;
        long sum = 0L;
        for (int i = n - 1; i >= 0 && numberToDecrease < k; i--, numberToDecrease++) {
            int candidateToSum = happiness[i] - numberToDecrease;
            if (candidateToSum > 0) {
                sum += candidateToSum;
            } else {
                break;
            }
        }
        return sum;
    }

}