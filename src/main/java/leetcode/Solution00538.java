package leetcode;

import leetcode.common.TreeNode;

/**
 * 538. Convert BST to Greater Tree
 * <a href="https://leetcode.com/problems/convert-bst-to-greater-tree">Web link</a>
 * Medium
 */

public class Solution00538 {

    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }

    private int convertBST(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int rightSum = convertBST(root.right, sum);
        root.val += rightSum;
        return convertBST(root.left, root.val);
    }

}
