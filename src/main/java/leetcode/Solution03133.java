/**
 * 3133. Minimum Array End
 * <a href="https://leetcode.com/problems/minimum-array-end">Web link</a>
 * Medium
 */

package leetcode;

public class Solution03133 {

    public long minEnd(int n, int x) {
        long result = x;
        long iX = 1;
        long iN = 1;
        while (iN < n) {
            if ((iX & x) == 0) {
                if ((iN & (n - 1)) > 0) {
                    result |= iX;
                }
                iN = iN << 1;
            }
            iX = iX << 1;
        }
        return result;
    }

}