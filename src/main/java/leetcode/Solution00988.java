package leetcode;

import leetcode.common.TreeNode;

/**
 * 988. Smallest String Starting From Leaf
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 * Medium
 */

public class Solution00988 {

    public String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root, new StringBuilder()).toString();
    }

    private StringBuilder smallestFromLeaf(TreeNode root, StringBuilder suffix) {
        if (root == null) {
            return suffix;
        }
        StringBuilder newSuffix = new StringBuilder(suffix.length() + 1)
                .append((char) ('a' + root.val))
                .append(suffix);
        if (root.left == null && root.right == null) {
            return newSuffix;
        }
        if (root.left == null) {
            return smallestFromLeaf(root.right, newSuffix);
        }
        if (root.right == null) {
            return smallestFromLeaf(root.left, newSuffix);
        }
        StringBuilder left = smallestFromLeaf(root.left, newSuffix);
        StringBuilder right = smallestFromLeaf(root.right, newSuffix);
        return left.compareTo(right) <= 0 ? left : right;
    }

}