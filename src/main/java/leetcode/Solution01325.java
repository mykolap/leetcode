package leetcode;

import leetcode.common.TreeNode;

/**
 * 1325. Delete Leaves With a Given Value
 * <a href="https://leetcode.com/problems/delete-leaves-with-a-given-value">Web link</a>
 * Medium
 */

public class Solution01325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target &&
            root.left == null &&
            root.right == null) {
            return null;
        }

        return root;
    }

}