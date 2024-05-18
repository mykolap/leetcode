package leetcode;

import leetcode.common.TreeNode;

/**
 * 979. Distribute Coins in Binary Tree
 * <a href="https://leetcode.com/problems/distribute-coins-in-binary-tree">Web link</a>
 * Medium
 */

public class Solution00979 {

    public int distributeCoins(TreeNode root) {
        int[] moves = {0};
        dfs(root, moves);
        return moves[0];
    }

    private int dfs(TreeNode node, int[] moves) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, moves);
        int right = dfs(node.right, moves);
        moves[0] += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }

}