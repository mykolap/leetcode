package leetcode;

import leetcode.common.TreeNode;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/">Web link</a>
 * Medium
 */

public class Solution01038 {

    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root, 0);
        return root;
    }

    private int bstToGst(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int rightSum = bstToGst(root.right, sum);
        root.val += rightSum;
        return bstToGst(root.left, root.val);
    }

}