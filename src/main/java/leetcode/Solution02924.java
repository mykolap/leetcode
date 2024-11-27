/**
 * 2924. Find Champion II
 * <a href="https://leetcode.com/problems/find-champion-ii">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02924 {

    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n]; // Track the number of incoming edges for each node.

        for (int[] edge : edges) {
            int v = edge[1];
            inDegree[v]++; // Increment in-degree for destination node.
        }

        int champion = 0; // To count nodes with zero in-degree.
        int ans = 0; // Store the node with zero in-degree.

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) { // Check for zero in-degree.
                champion++;
                ans = i;
            }
        }

        // If there's more than one champion, return -1.
        if (champion > 1)
            return -1;
        return ans;
    }

}