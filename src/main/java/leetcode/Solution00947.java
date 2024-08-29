package leetcode;

/**
 * 947. Most Stones Removed with Same Row or Column
 * <a href="https://leetcode.com/problems/most-stones-removed-with-same-row-or-column">Web link</a>
 * Medium
 */

public class Solution00947 {

    public int removeStones(int[][] stones) {
        int[] numOfIslands = {0};
        int[] parent = new int[20003];
        for (int[] stone : stones) {
            unionSets(stone[0] + 1, stone[1] + 10002, parent, numOfIslands);
        }
        return stones.length - numOfIslands[0];
    }

    public void unionSets(int a, int b, int[] parent, int[] numOfIslands) {
        int parA = findParent(a, parent, numOfIslands);
        int parB = findParent(b, parent, numOfIslands);
        if (parA != parB) {
            parent[parB] = parA;
            numOfIslands[0]--;
        }
    }

    public int findParent(int node, int[] parent, int[] numOfIslands) {
        if (parent[node] == 0) {
            parent[node] = node;
            numOfIslands[0]++;
        }
        if (parent[node] == node) {
            return node;
        }
        int par = findParent(parent[node], parent, numOfIslands);
        parent[node] = par;
        return par;
    }

}