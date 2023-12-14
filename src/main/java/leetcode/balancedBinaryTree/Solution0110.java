package leetcode.balancedBinaryTree;

import leetcode.common.TreeNode;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 110. Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * 1. a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */
public class Solution0110 {

    // Time: O(n^2)
    // Space: O(n)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = maxDepthRecursiveDfs(root.left);
        int rightDepth = maxDepthRecursiveDfs(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1
               && isBalanced(root.left)
               && isBalanced(root.right);
    }

    // Time: O(n)
    // Space: O(n)
    public int maxDepthRecursiveDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthRecursiveDfs(root.left), maxDepthRecursiveDfs(root.right));
    }

    // Time: O(n)
    // Space: O(n)
    public boolean isBalancedOptimized(TreeNode root) {
        AtomicBoolean isBalanced = new AtomicBoolean(true);
        dfs(root, isBalanced);
        return isBalanced.get();
    }

    private int dfs(TreeNode root, AtomicBoolean isBalanced) {
        if (root == null) {
            return 0;
        }

        int leftDepth = dfs(root.left, isBalanced);
        if (!isBalanced.get()) {
            return Integer.MIN_VALUE;
        }

        int rightDepth = dfs(root.right, isBalanced);
        if (!isBalanced.get()) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced.set(false);
            return Integer.MIN_VALUE;
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }

}
