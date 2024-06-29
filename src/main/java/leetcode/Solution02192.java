package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2192. All Ancestors of a Node in a Directed Acyclic Graph
 * https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
 * Medium
 */

public class Solution02192 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adjacencyList = new List[n];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
            result.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
        }

        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            addRecursivelyAncestors(currentIndex, adjacencyList, currentIndex, result);
        }
        return result;
    }

    private static void addRecursivelyAncestors(int parentIndex, List<Integer>[] adjacencyList, int currentIndex, List<List<Integer>> result) {
        List<Integer> currentResultLine = adjacencyList[currentIndex];
        for (int child : currentResultLine) {
            // add parent to the child's ancestors if it's not already there
            final List<Integer> childResultLine = result.get(child);
            if (childResultLine.isEmpty() ||
                childResultLine.getLast() != parentIndex) {
                childResultLine.add(parentIndex);
                addRecursivelyAncestors(parentIndex, adjacencyList, child, result);
            }
        }
    }

}