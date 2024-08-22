package leetcode;

/**
 * 476. Number Complement
 * <a href="https://leetcode.com/problems/number-complement">Web link</a>
 * Easy
 */

public class Solution00476 {

    public int findComplement(int num) {
        int mask = 1;
        while (mask < num) {
            mask = (mask << 1) + 1;
        }
        return num ^ mask;
    }

    public int findComplementBinaryStr(int num) {
        if (num == 0) return 1;
        int bitLength = Integer.toBinaryString(num).length();
        int mask = (1 << bitLength) - 1;
        return num ^ mask;
    }

    public int findComplementBitByBit(int num) {
        int complement = 0;
        int power = 0;
        while (num > 0) {
            int rightMostBit = num & 1;
            if (rightMostBit == 0) { // we should place 1 in this position, as complement to 0
                complement += 1 << power;
            } // else we already have 0 at position as complement to 1, because 0 is default bit in integer
            num >>= 1;
            power++;
        }
        return complement;
    }

}