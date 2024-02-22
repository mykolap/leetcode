package leetcode;

/**
 * 997. Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/
 * Easy
 */

public class Solution00997 {

    // Time: O(n)
    // Space: O(n)
    public int findJudge(int n, int[][] trust) {
        // Create an array to store the number of trusts each person receives
        int[] inDegree = new int[n + 1];

        // Create an array to store the number of trusts each person gives
        int[] outDegree = new int[n + 1];

        // Iterate over the trust array
        for (int[] t : trust) {
            // Increment the number of trusts the person gives
            outDegree[t[0]]++;
            // Increment the number of trusts the person receives
            inDegree[t[1]]++;
        }

        // Iterate over all the people
        for (int i = 1; i <= n; i++) {
            // If a person does not trust anyone (outDegree is 0) and is trusted by everyone else (inDegree is n - 1)
            if (outDegree[i] == 0 && inDegree[i] == n - 1) {
                // Return the person as the town judge
                return i;
            }
        }

        // If no town judge is found, return -1
        return -1;
    }

}