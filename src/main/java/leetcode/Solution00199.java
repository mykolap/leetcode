package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 199. Binary Tree Right Side View
 * Medium
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 * Input: root = []
 * Output: []
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class Solution00199 {

    // Time O(n)
    // Space O(n)
    public List<Integer> rightSideViewBfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

}
