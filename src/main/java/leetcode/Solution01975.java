/**
 * 1975. Maximum Matrix Sum
 * <a href="https://leetcode.com/problems/maximum-matrix-sum">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution01975 {

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                int absNum;
                if (num < 0) {
                    absNum = Math.abs(num);
                    negativeCount++;
                } else {
                    absNum = num;
                }
                sum += absNum;
                min = Math.min(min, absNum);
            }
        }

        if (negativeCount % 2 == 0) {
            return sum;
        }
        return sum - 2L * min;
    }

}