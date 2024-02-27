package leetcode;

import javafx.util.Pair;
import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/same-tree/
 * 100. Same Tree
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 * <p>
 * Example 1:
 * <p>
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */
public class Solution00100 {

    // Time: O(n)
    // Space: O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Create a queue to store the nodes that need to be compared.
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();

        // Add the root nodes of the two trees to the queue.
        queue.add(new Pair<>(p, q));

        // While the queue is not empty, do the following:
        while (!queue.isEmpty()) {

            // Remove the next pair of nodes from the queue.
            Pair<TreeNode, TreeNode> nodes = queue.poll();
            p = nodes.getKey();
            q = nodes.getValue();

            // If both nodes are null, then the trees are the same.
            if (p == null && q == null) {
                continue;
            }

            // If either node is null, then the trees are not the same.
            if (p == null || q == null) {
                return false;
            }

            // If the values of the nodes are not the same, then the trees are not the same.
            if (p.val != q.val) {
                return false;
            }

            // Add the left and right subtrees of the current nodes to the queue.
            queue.add(new Pair<>(p.left, q.left));
            queue.add(new Pair<>(p.right, q.right));
        }

        // If the queue is empty, then the trees are the same.
        return true;
    }

}
