package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 834. Sum of Distances in Tree
 * <a href="https://leetcode.com/problems/sum-of-distances-in-tree/">Web link</a> |
 * Hard
 */

public class Solution00834 {

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] count = new int[n];
        int[] res = new int[n];
        Arrays.fill(count, 1);

        postOrder(0, -1, adj, count, res);
        preOrder(0, -1, adj, count, res, n);

        return res;
    }

    private void postOrder(int node, int parent, List<Integer>[] adj, int[] count, int[] res) {
        for (int neighbor : adj[node]) {
            if (neighbor == parent) {
                continue;
            }
            postOrder(neighbor, node, adj, count, res);
            count[node] += count[neighbor];
            res[node] += res[neighbor] + count[neighbor];
        }
    }

    private void preOrder(int node, int parent, List<Integer>[] adj, int[] count, int[] res, int n) {
        for (int neighbor : adj[node]) {
            if (neighbor == parent) {
                continue;
            }
            res[neighbor] = res[node] - count[neighbor] + n - count[neighbor];
            preOrder(neighbor, node, adj, count, res, n);
        }
    }

    public int[] sumOfDistancesInTree2(int n, int[][] edges) {
        int[] count = new int[n];
        int[] res = new int[n];
        Arrays.fill(count, 1);
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(new ArrayList<>());
        for (int[] edge : edges) {
            arr.get(edge[0]).add(edge[1]);
            arr.get(edge[1]).add(edge[0]);
        }
        getCounts(arr, 0, -1, count, res);
        buildSum(arr, 0, -1, count, res);
        return res;
    }

    //This is used to get counts of nodes in subtrees and the correct result of root node(0)
    void getCounts(List<List<Integer>> adj, int cur, int par, int[] count, int[] res) {
        for (int ch : adj.get(cur)) {
            if (ch == par) continue;
            getCounts(adj, ch, cur, count, res);
            count[cur] += count[ch];
            //Here we are formulating res array, but res for only parent is calculated correct
            res[cur] += res[ch] + count[ch];
        }
    }

    //This is used to get correct res for all other nodes after knowing res of root
    // res[X] = res[Y(parent in this case)] + N - 2*count[X]
    void buildSum(List<List<Integer>> adj, int cur, int par, int[] count, int[] res) {
        for (int ch : adj.get(cur)) {
            if (ch == par) continue;
            res[ch] = res[cur] + adj.size() - 2 * count[ch];
            buildSum(adj, ch, cur, count, res);
        }
    }
}