/**
 * 2554. Maximum Number of Integers to Choose From a Range I
 * <a href="https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution02554 {

    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            int sumCandidate = sum + i;
            if (sumCandidate > maxSum) {
                return count;
            }
            sum = sumCandidate;
            count++;
        }

        return count;
    }

}