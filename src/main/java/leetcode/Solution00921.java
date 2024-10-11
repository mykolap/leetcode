package leetcode;

/**
 * 921. Minimum Add to Make Parentheses Valid
 * <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid">Web link</a>
 * Medium
 */

public class Solution00921 {

    public int minAddToMakeValid(String s) {
        int o = 0, c = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                o++;
            } else if (o > 0) {
                o--;
            } else {
                c++;
            }
        }
        return o + c;
    }

}