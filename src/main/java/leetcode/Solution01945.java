package leetcode;

import java.math.BigInteger;

/**
 * 1945. Sum of Digits of String After Convert
 * <a href="https://leetcode.com/problems/sum-of-digits-of-string-after-convert">Web link</a> |
 * Easy
 */

public class Solution01945 {

    public int getLucky(String s, int k) {
        BigInteger convert = convert(s);
        for (int i = 0; i < k; i++) {
            convert = transform(convert);
        }
        return convert.intValue();
    }

    private BigInteger transform(BigInteger convert) {
        BigInteger sum = BigInteger.ZERO;
        while (convert.compareTo(BigInteger.valueOf(9)) > 0) {
            sum = sum.add(convert.mod(BigInteger.TEN));
            convert = convert.divide(BigInteger.TEN);
        }
        return sum.add(convert);
    }

    private BigInteger convert(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }
        return new BigInteger(sb.toString());
    }

}