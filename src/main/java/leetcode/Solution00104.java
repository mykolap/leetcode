package leetcode;

import leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
public class Solution00104 {

    // Time: O(n)
    // Space: O(n)
    public int maxDepthRecursiveDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthRecursiveDfs(root.left), maxDepthRecursiveDfs(root.right));
    }

    // Time: O(n)
    // Space: O(n)
    public int maxDepthIterativeBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Create a queue to store the nodes that need to be visited.
        Queue<TreeNode> queue = new LinkedList<>();

        // Add the root node to the queue.
        queue.add(root);

        // Create a variable to store the maximum depth.
        int maxDepth = 0;

        // While the queue is not empty, do the following:
        while (!queue.isEmpty()) {
            // Remove the next node from the queue.
            final int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    // Add the left child of the node to the queue.
                    queue.add(node.left);
                }
                if (node.right != null) {
                    // Add the right child of the node to the queue.
                    queue.add(node.right);
                }
            }

            maxDepth++;
        }

        // Return the maximum depth.
        return maxDepth;
    }

    // Time: O(n)
    // Space: O(n)
    public int maxDepthIterativeDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Create a stack to store the nodes that need to be visited.
        Deque<TreeNode> stack = new LinkedList<>();

        // Create a stack to store the depths of the nodes that need to be visited.
        Deque<Integer> depths = new LinkedList<>();

        // Add the root node to the stack.
        stack.push(root);

        // Add the depth of the root node to the stack.
        depths.push(1);

        // Create a variable to store the maximum depth.
        int maxDepth = 1;

        // While the stack is not empty, do the following:
        while (!stack.isEmpty()) {
            // Remove the next node from the stack.
            TreeNode node = stack.pop();
            // Remove the depth of the next node from the stack.
            int depth = depths.pop();

            // If the depth of the next node is greater than the maximum depth, update the maximum depth.
            if (depth > maxDepth) {
                maxDepth = depth;
            }

            // If the left child of the next node is not null, do the following:
            if (node.left != null) {
                // Add the left child of the next node to the stack.
                stack.push(node.left);
                // Add the depth of the left child of the next node to the stack.
                depths.push(depth + 1);
            }

            // If the right child of the next node is not null, do the following:
            if (node.right != null) {
                // Add the right child of the next node to the stack.
                stack.push(node.right);
                // Add the depth of the right child of the next node to the stack.
                depths.push(depth + 1);
            }
        }

        // Return the maximum depth.
        return maxDepth;
    }

}

