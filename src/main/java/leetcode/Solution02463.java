/**
 * 2463. Minimum Total Distance Traveled
 * <a href="https://leetcode.com/problems/minimum-total-distance-traveled">Web link</a> |
 * Hard
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution02463 {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(null);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        List<Integer> factoryPos = new ArrayList<>();
        for (int[] position : factory) {
            for (int i = 0; i < position[1]; i++) {
                factoryPos.add(position[0]);
            }
        }

        int m = robot.size();
        int n = factoryPos.size();
        long[][] dp = new long[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][n] = 1_000_000_000_000L;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                long pick = Math.abs(robot.get(i) - factoryPos.get(j)) + dp[i + 1][j + 1];
                long notPick = dp[i][j + 1];
                dp[i][j] = Math.min(pick, notPick);
            }
        }
        return dp[0][0];
    }

    public long minimumTotalDistance2(List<Integer> robot, int[][] factory) {
        robot.sort(null);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        List<Integer> factoryPos = new ArrayList<>();
        for (int[] position : factory) {
            for (int i = 0; i < position[1]; i++) {
                factoryPos.add(position[0]);
            }
        }

        int m = robot.size();
        int n = factoryPos.size();
        long[][] dp = new long[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = 0L;
                } else if (j == 0 || j < i) {
                    dp[i][j] = Long.MAX_VALUE;
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + Math.abs(robot.get(i - 1) - factoryPos.get(j - 1)));
                }
            }
        }
        return dp[m][n];
    }

}