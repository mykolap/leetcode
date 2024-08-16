package leetcode;

import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 * <a href="https://leetcode.com/problems/maximum-distance-in-arrays">Web link</a>
 * Medium
 */

public class Solution00624 {

    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        final List<Integer> firstArr = arrays.getFirst();
        int minSoFar = firstArr.getFirst();
        int maxSoFar = firstArr.getLast();
        int result = 0;
        for (int i = 1; i < n; i++) {
            final List<Integer> currentArr = arrays.get(i);
            result = Math.max(result, currentArr.getLast() - minSoFar);
            result = Math.max(result, maxSoFar - currentArr.getFirst());
            minSoFar = Math.min(minSoFar, currentArr.getFirst());
            maxSoFar = Math.max(maxSoFar, currentArr.getLast());
        }
        return result;
    }

}