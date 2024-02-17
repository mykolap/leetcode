package leetcode;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 226. Invert Binary Tree
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class Solution00226 {

    // Time: O(n)
    // Space: O(n)
    public TreeNode invertTree(TreeNode root) {
        // If the root is null, return null.
        if (root == null) {
            return null;
        }

        // save left subtrees
        TreeNode tmpLeft = root.left;

        // Invert the left subtree of the root.
        root.left = invertTree(root.right);
        // Invert the right subtree of the root.
        root.right = invertTree(tmpLeft);

        // Return the root.
        return root;
    }

    // Time: O(n)
    // Space: O(n)
    public TreeNode invertTreeIterative(TreeNode root) {
        // If the root is null, return null.
        if (root == null) {
            return null;
        }
        // Create a queue to store the nodes that need to be inverted.
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the root to the queue.
        queue.add(root);
        // While the queue is not empty, do the following:
        while (!queue.isEmpty()) {
            // Remove the first node from the queue.
            TreeNode current = queue.remove();

            // save left subtrees
            TreeNode tmpLeft = current.left;

            // Invert the left subtree of the current node.
            current.left = current.right;
            // Invert the right subtree of the current node.
            current.right = tmpLeft;

            // If the left subtree of the current node is not null, add it to the queue.
            if (current.left != null) {
                queue.add(current.left);
            }
            // If the right subtree of the current node is not null, add it to the queue.
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        // Return the root.
        return root;
    }
}
