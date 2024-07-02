package leetcode;

/**
 * 1550. Three Consecutive Odds
 * <a href="https://leetcode.com/problems/three-consecutive-odds">Web link</a>
 * Easy
 */

public class Solution01550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int oddCount = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                ++oddCount;
                if (oddCount == 3) {
                    return true;
                }
            } else {
                oddCount = 0;
            }
        }
        return false;
    }

}