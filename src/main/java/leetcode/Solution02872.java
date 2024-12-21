/**
 * 2872. Maximum Number of K-Divisible Components
 * <a href="https://leetcode.com/problems/maximum-number-of-k-divisible-components">Web link</a> |
 * Hard
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution02872 {

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        long totalSum = Arrays.stream(values)
                .asLongStream()
                .sum();
        
        int[] result = new int[1];
        boolean[] visited = new boolean[n];
        postorder(0, tree, values, visited, totalSum, k, result);

        return result[0];
    }

    private long postorder(int node, List<List<Integer>> tree, int[] values,
                           boolean[] visited, long totalSum, int k, int[] result) {
        visited[node] = true;
        long subtreeSum = values[node];
        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                subtreeSum += postorder(neighbor, tree, values, visited, totalSum, k, result);
            }
        }

        if (subtreeSum % k == 0 && (totalSum - subtreeSum) % k == 0) {
            result[0]++;
            return 0;
        }

        return subtreeSum;
    }

}