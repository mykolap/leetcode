package leetcode;

import java.util.Arrays;

/**
 * 2037. Minimum Number of Moves to Seat Everyone
 * <a href="https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone">Web link</a> |
 * Easy
 */

public class Solution02037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        int moves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < n; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

}