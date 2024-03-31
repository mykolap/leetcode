package leetcode;

/**
 * 3096. Minimum Levels to Gain More Points
 * <a href="https://leetcode.com/problems/minimum-levels-to-gain-more-points/">Web link</a> |
 * Medium
 */

public class Solution03096 {

    public int minimumLevels(int[] possible) {
        int maxScore = 0;
        for (int j : possible) {
            maxScore += j == 1 ? 1 : -1;
        }

        int danielScore = 0;
        int bobScore = maxScore;
        int maxPlays = possible.length - 1; // bob should play at least 1 level

        for (int i = 0; i < maxPlays; i++) {
            if (possible[i] == 1) {
                danielScore++;
                bobScore--;
            } else {
                danielScore--;
                bobScore++;
            }
            if (danielScore > bobScore) {
                return i + 1;
            }
        }

        return -1;
    }

}
