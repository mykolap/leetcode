package leetcode;

/**
 * 2678. Number of Senior Citizens
 * <a href="https://leetcode.com/problems/number-of-senior-citizens">Web link</a> |
 * Easy
 */

public class Solution02678 {

    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            if (detail.charAt(11) > '6' ||
                (detail.charAt(11) == '6' && detail.charAt(12) != '0')) {
                count++;
            }
        }
        return count;
    }

}