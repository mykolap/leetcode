package leetcode;

import leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 124. Binary Tree Maximum Path Sum
 * Hard
 * <p>
 * Share
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any node sequence from some starting node to any node
 * in the tree along the parent-child connections. The path must contain at least one node and
 * does not need to go through the root.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * Output: 6
 * Example 2:
 * <p>
 * <p>
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 3 * 104].
 * -1000 <= Node.val <= 1000
 */
public class Solution00124 {

    public int maxPathSum(TreeNode root) {
        TraverseResult traverseResult = new TraverseResult();
        traverseResult.max = Integer.MIN_VALUE;
        traverse(root, traverseResult);
        return traverseResult.max;
    }

    private int traverse(TreeNode root, TraverseResult traverseResult) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, traverse(root.left, traverseResult));
        int right = Math.max(0, traverse(root.right, traverseResult));
        traverseResult.max = Math.max(traverseResult.max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    static class TraverseResult {
        int max;
    }

}
