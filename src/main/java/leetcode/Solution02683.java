/**
 * 2683. Neighboring Bitwise XOR
 * <a href="https://leetcode.com/problems/neighboring-bitwise-xor">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02683 {

    public boolean doesValidArrayExist(int[] derived) {
        int xr = 0;
        for (int x : derived) {
            xr = xr ^ x;
        }
        return xr == 0;
    }

}