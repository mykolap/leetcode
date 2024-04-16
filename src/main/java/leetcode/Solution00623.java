package leetcode;

import leetcode.common.TreeNode;

/**
 * 623. Add One Row to Tree
 * <a href="https://leetcode.com/problems/add-one-row-to-tree">Web link</a>
 * Medium
 */

public class Solution00623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        addOneRow(root, val, depth, 1);
        return root;
    }

    private void addOneRow(TreeNode root, int val, int depth, int currentDepth) {
        if (root == null) {
            return;
        }
        if (currentDepth == depth - 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return;
        }
        addOneRow(root.left, val, depth, currentDepth + 1);
        addOneRow(root.right, val, depth, currentDepth + 1);
    }

}