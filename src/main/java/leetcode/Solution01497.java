package leetcode;

/**
 * 1497. Check If Array Pairs Are Divisible by k
 * <a href="https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k">Web link</a>
 * Medium
 */

public class Solution01497 {

    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int num : arr) {
            int mod = num % k;
            if (mod < 0) {
                mod += k;
            }
            freq[mod]++;
        }
        if (freq[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }

}