package leetcode;

import leetcode.common.TreeNode;

/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 * Easy
 */

public class Solution00404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

}