package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">
 * 102. Binary Tree Level Order Traversal
 * </a>
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
 * level by level).
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Follow-up: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution00102 {

    // Time O(n)
    // Space O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return List.of();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }

        return result;
    }
}
