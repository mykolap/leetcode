package leetcode;

import leetcode.common.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 543. Diameter of Binary Tree
 * <p>
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 */
public class Solution00543 {

    // Time: O(n)
    // Space: O(n)
    public int diameterOfBinaryTreeRecursive(TreeNode root) {
        int[] max = new int[1];
        height(root, max);
        return max[0];
    }

    private int height(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left, max);
        int right = height(node.right, max);
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
    }

    // Time: O(n)
    // Space: O(n)
    public int diameterOfBinaryTreeIterative(TreeNode root) {
        int max = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int left = map.getOrDefault(node.left, 0);
                int right = map.getOrDefault(node.right, 0);
                map.put(node, Math.max(left, right) + 1);
                max = Math.max(max, left + right);
            }
        }
        return max;
    }

}
