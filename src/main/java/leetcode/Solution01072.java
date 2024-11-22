/**
 * 1072. Flip Columns For Maximum Number of Equal Rows
 * <a href="https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows">Web link</a>
 * Medium
 */

package leetcode;

import java.util.Arrays;

public class Solution01072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int ans = 0;

        for (int[] bin : matrix) {
            // Create inverse of the current row
            int[] invBin = new int[n];
            for (int j = 0; j < n; j++) {
                invBin[j] = bin[j] == 0 ? 1 : 0;
            }

            // Compare with all rows
            int tmp = 0;
            for (int[] cur : matrix) {
                if (Arrays.equals(cur, bin) || Arrays.equals(cur, invBin)) {
                    tmp++;
                }
            }

            ans = Math.max(tmp, ans);
        }

        return ans;
    }

}