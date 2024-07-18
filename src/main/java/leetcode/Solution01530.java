package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1530. Number of Good Leaf Nodes Pairs
 * <a href="https://leetcode.com/problems/number-of-good-leaf-nodes-pairs">Web link</a> |
 * Medium
 */

public class Solution01530 {

    public int countPairs(TreeNode root, int distance) {
        int[] count = new int[1];
        dfs(root, distance, count);
        return count[0];
    }

    private List<Integer> dfs(TreeNode node, int distance, int[] count) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            return List.of(1);
        }
        List<Integer> left = dfs(node.left, distance, count);
        List<Integer> right = dfs(node.right, distance, count);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            for (int l : left) {
                for (int r : right) {
                    if (l + r <= distance) {
                        count[0]++;
                    }
                }
            }
        }
        List<Integer> current = new ArrayList<>();
        promoteToParent(distance, left, current);
        promoteToParent(distance, right, current);
        return current;
    }

    private static void promoteToParent(int distance, List<Integer> left, List<Integer> current) {
        if (left == null) {
            return;
        }
        for (int l : left) {
            if (l + 1 < distance) {
                current.add(l + 1);
            }
        }
    }

}