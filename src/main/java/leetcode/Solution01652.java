/**
 * 1652. Defuse the Bomb
 * <a href="https://leetcode.com/problems/defuse-the-bomb">Web link</a> |
 * Easy
 */

package leetcode;

public class Solution01652 {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = 0; j < k; j++) {
                    res[i] += code[(i + j + 1) % n];
                }
            } else {
                for (int j = 0; j < -k; j++) {
                    res[i] += code[(i - j - 1 + n) % n];
                }
            }
        }
        return res;
    }

}