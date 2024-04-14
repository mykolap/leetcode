package leetcode;

/**
 * 3110. Score of a String
 * https://leetcode.com/problems/score-of-a-string/
 * Easy
 */
public class Solution03110 {

    public int scoreOfString(String s) {
        int n = s.length();
        int score = 0;
        for (int i = 1; i < n; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return score;
    }

}
