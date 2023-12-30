package leetcode.subtreeOfAnotherTree;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * 572. Subtree of Another Tree
 * <p>
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */
public class Solution0572 {

    // Time: O(n * m)
    // Space: O(n + m)
    public boolean isSubtreeDfsRecursive(TreeNode root, TreeNode subRoot) {
        // If the subRoot is null, return true.
        if (subRoot == null) {
            return true;
        }
        // If the root is null, return false.
        if (root == null) {
            return false;
        }

        // Return whether the subRoot is a subtree of the left subtree or the right subtree.
        return isSameTreeDfsRecursive(root, subRoot) ||
               isSubtreeDfsRecursive(root.left, subRoot) ||
               isSubtreeDfsRecursive(root.right, subRoot);
    }

    // Time: O(n)
    // Space: O(n)
    private boolean isSameTreeDfsRecursive(TreeNode rootFragment, TreeNode subRoot) {
        if (rootFragment == null || subRoot == null) {
            return rootFragment == subRoot;
        }
        if (rootFragment.val != subRoot.val) {
            return false;
        }
        return isSameTreeDfsRecursive(rootFragment.left, subRoot.left) &&
               isSameTreeDfsRecursive(rootFragment.right, subRoot.right);
    }

    // Time: O(n * m)
    // Space: O(n + m)
    public boolean isSubtreeBfsIterative(TreeNode root, TreeNode subRoot) {
        // If the subRoot is null, return true.
        if (subRoot == null) {
            return true;
        }
        // If the root is null, return false.
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (isSameTreeBfsIterative(current, subRoot)) {
                return true;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return false;
    }

    private boolean isSameTreeBfsIterative(TreeNode rootFragment, TreeNode subRoot) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(rootFragment);
        queue2.add(subRoot);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            queue1.add(node1.left);
            queue1.add(node1.right);
            queue2.add(node2.left);
            queue2.add(node2.right);
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }

}
