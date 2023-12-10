package leetcode.maximumDepthOfBinaryTree;

import leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 104. Maximum Depth of Binary Tree
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along
 * the longest path from the root node down to the farthest leaf node.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * Output: 0
 * <p>
 * Example 4:
 * <p>
 * Input: root = [0]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class Solution0104 {

    // Time: O(n)
    // Space: O(n)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}

