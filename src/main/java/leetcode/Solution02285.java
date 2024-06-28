package leetcode;

import java.util.Arrays;

/**
 * 2285. Maximum Total Importance of Roads
 * <a href="https://leetcode.com/problems/maximum-total-importance-of-roads">Web link</a> |
 * Medium
 */

public class Solution02285 {

    public long maximumImportance(int n, int[][] roads) {
        int[] connectionsCount = new int[n];
        for (int[] road : roads) {
            connectionsCount[road[0]]++;
            connectionsCount[road[1]]++;
        }
        long startImportance = 1;
        Arrays.sort(connectionsCount);
        long totalImportance = 0;
        for (int i = 0; i < n; i++) {
            totalImportance += startImportance * connectionsCount[i];
            startImportance++;
        }
        return totalImportance;
    }

}