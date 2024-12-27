/**
 * 1014. Best Sightseeing Pair
 * <a href="https://leetcode.com/problems/best-sightseeing-pair">Web link</a>
 * Medium
 */

package leetcode;

public class Solution01014 {

    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        int maxPair = values[0] - 1;
        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, maxPair + values[i]);
            maxPair = Math.max(maxPair - 1, values[i] - 1);
        }
        return result;
    }

    public int maxScoreSightseeingPairDp(int[] values) {
        int result = 0;
        int[] dpLeftMax = new int[values.length];
        dpLeftMax[0] = values[0] - 1;
        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, dpLeftMax[i - 1] + values[i]);
            dpLeftMax[i] = Math.max(dpLeftMax[i - 1] - 1, values[i] - 1);
        }
        return result;
    }
}