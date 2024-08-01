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
            int firstDigit = detail.charAt(11) - '0';
            if (firstDigit < 6) {
                continue;
            }
            if (firstDigit == 6) {
                int secondDigit = detail.charAt(12) - '0';
                if (secondDigit == 0) {
                    continue;
                }
            }
            count++;
        }
        return count;
    }

}