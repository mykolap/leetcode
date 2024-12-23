/**
 * 2471. Minimum Number of Operations to Sort a Binary Tree by Level
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level">Web link</a> |
 * Medium
 */

package leetcode;

import leetcode.common.TreeNode;

import java.util.*;

public class Solution02471 {

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                arr[i] = curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            count += minSwaps(arr);
        }
        return count;
    }

    private int minSwaps(int[] arr) {
        int n = arr.length;
        int[] temp = arr.clone();
        Arrays.sort(temp);
        boolean[] visited = new boolean[n];
        int swaps = 0;
        Map<Integer, Integer> indexMap = createIndexMap(arr);

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == temp[i]) continue;
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(temp[j]);
                cycleSize++;
            }
            if (cycleSize > 0) swaps += (cycleSize - 1);
        }
        return swaps;
    }

    private Map<Integer, Integer> createIndexMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        return map;
    }

}