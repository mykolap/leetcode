/**
 * 2429. Minimize XOR
 * <a href="https://leetcode.com/problems/minimize-xor">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02429 {

    public int minimizeXor(int num1, int num2) {
        int countBitsNum = Integer.bitCount(num2);
        int result = 0;

        for (int i = 31; i >= 0 && countBitsNum > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i);
                countBitsNum--;
            }
        }

        for (int i = 0; i < 32 && countBitsNum > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                countBitsNum--;
            }
        }

        return result;
    }

}