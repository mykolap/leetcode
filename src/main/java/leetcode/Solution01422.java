/**
 * 1422. Maximum Score After Splitting a String
 * <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string">Web link</a>
 * Easy
 */

package leetcode;

public class Solution01422 {

    public int maxScore(String s) {
        char[] chArr = s.toCharArray();
        int count1 = 0;
        for (char ch : chArr) {
            if (ch == '1') {
                count1++;
            }
        }
        int maxResult = 0;
        int count0 = 0;
        int lastIndex = chArr.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            char ch = chArr[i];
            if (ch == '0') {
                if (i < lastIndex) {
                    count0++;
                }
            } else if (ch == '1') {
                count1--;
            }
            maxResult = Math.max(maxResult, count0 + count1);
        }
        return maxResult;
    }

}