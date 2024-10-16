package leetcode;

/**
 * 1405. Longest Happy String
 * <a href="https://leetcode.com/problems/longest-happy-string">Web link</a>
 * Medium
 */

public class Solution01405 {

    public String longestDiverseString(int a, int b, int c) {
        int currentA = 0;
        int currentB = 0;
        int currentC = 0;

        int totalIterations = a + b + c;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < totalIterations; i++) {
            if (shouldAppend(a, b, c, currentA, currentB, currentC)) {
                ans.append('a');
                a--;
                currentA++;
                currentB = 0;
                currentC = 0;
            } else if (shouldAppend(b, a, c, currentB, currentA, currentC)) {
                ans.append('b');
                b--;
                currentB++;
                currentA = 0;
                currentC = 0;
            } else if (shouldAppend(c, a, b, currentC, currentA, currentB)) {
                ans.append('c');
                c--;
                currentC++;
                currentA = 0;
                currentB = 0;
            }
        }
        return ans.toString();
    }

    private boolean shouldAppend(int allowedFirst, int allowedSecond, int allowedThird, int currentFirst, int currentSecond, int currentThird) {
        return (allowedFirst >= allowedSecond && allowedFirst >= allowedThird && currentFirst != 2) || (allowedFirst > 0 && (currentSecond == 2 || currentThird == 2));
    }


}