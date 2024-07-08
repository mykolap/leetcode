package leetcode;

/**
 * 1823. Find the Winner of the Circular Game
 * <a href="https://leetcode.com/problems/find-the-winner-of-the-circular-game">Web link</a> |
 * Medium
 */

public class Solution01823 {

    public int findTheWinner(int n, int k) {
        int winner = 0; // Starting from the first player
        for (int totalPlayers = 2; totalPlayers <= n; totalPlayers++) {
            winner = (winner + k) % totalPlayers;
        }
        return winner + 1; // Adjusting to 1-based indexing
    }

    public int findTheWinnerRecursively(int n, int k) {
        return findWinnerRecursivelyHelper(n, k) + 1;
    }

    private int findWinnerRecursivelyHelper(int n, int eliminationStep) {
        if (n == 1) {
            return 0;
        }
        int nextEliminationPosition = findWinnerRecursivelyHelper(n - 1, eliminationStep) + eliminationStep;
        return nextEliminationPosition % n;
    }

}