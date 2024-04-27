package leetcode;

import java.util.Arrays;

/**
 * 514. Freedom Trail
 * <a href="https://leetcode.com/problems/freedom-trail">Web link</a>
 * Hard
 */

public class Solution00514 {

    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length();
        int keyLen = key.length();
        int[] dp = new int[ringLen];
        for (int i = keyLen - 1; i >= 0; i--) {
            int[] dpNew = new int[ringLen];
            Arrays.fill(dpNew, Integer.MAX_VALUE);
            for (int j = 0; j < ringLen; j++) {
                for (int k = 0; k < ringLen; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int steps = Math.min(diff, ringLen - diff);
                        dpNew[j] = Math.min(dpNew[j], steps + dp[k]);
                    }
                }
            }
            dp = dpNew;
        }
        return dp[0] + keyLen;
    }

}