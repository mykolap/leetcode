package leetcode;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 98. Validate Binary Search Tree
 * Medium
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class Solution00098 {

    // Time O(n)
    // Space O(n)
    public boolean isValidBstDfs(TreeNode root) {
        return isValidBstDfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBstDfs(TreeNode currentNode, long min, long max) {
        if (currentNode == null) {
            return true;
        }

        if (currentNode.val <= min) {
            return false;
        }

        if (currentNode.val >= max) {
            return false;
        }

        return isValidBstDfs(currentNode.left, min, currentNode.val) && isValidBstDfs(currentNode.right, currentNode.val, max);
    }

    public boolean isValidBstBfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<QueueData> queue = new LinkedList<>();
        queue.add(new QueueData(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!queue.isEmpty()) {
            QueueData queueData = queue.poll();
            TreeNode currentNode = queueData.node;
            long min = queueData.min;
            long max = queueData.max;

            if (currentNode.val <= min) {
                return false;
            }

            if (currentNode.val >= max) {
                return false;
            }

            if (currentNode.left != null) {
                queue.add(new QueueData(currentNode.left, min, currentNode.val));
            }

            if (currentNode.right != null) {
                queue.add(new QueueData(currentNode.right, currentNode.val, max));
            }
        }

        return true;
    }

    private static class QueueData {
        TreeNode node;
        long min;
        long max;

        QueueData(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

}
