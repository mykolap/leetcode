package leetcode;

import leetcode.common.TreeNode;

/**
 * 2331. Evaluate Boolean Binary Tree
 * <a href="https://leetcode.com/problems/evaluate-boolean-binary-tree">Web link</a> |
 * Easy
 */

public class Solution02331 {

    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return switch (root.val) {
            case 1 -> true;
            case 2 -> evaluateTree(root.left) || evaluateTree(root.right);
            case 3 -> evaluateTree(root.left) && evaluateTree(root.right);
            default -> false;
        };
    }

}