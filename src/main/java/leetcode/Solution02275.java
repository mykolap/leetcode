/**
 * 2275. Largest Combination With Bitwise AND Greater Than Zero
 * <a href="https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02275 {

    public int largestCombination(int[] candidates) {
        int maxFreq = 0;
        for (int i = 0; i < 32; i++) {
            int freq = 0;
            for (int candidate : candidates) {
                if ((candidate & (1 << i)) != 0) {
                    freq++;
                }
            }
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
    }

}