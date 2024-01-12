package leetcode;

import leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 230. Kth Smallest Element in a BST
 * #medium
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find
 * the kth smallest frequently, how would you optimize?
 */
public class Solution00230 {

    // Time O(n)
    // Space O(n)
    public int kthSmallestRecursive(TreeNode root, int k) {
        TraverseData traverseData = new TraverseData();
        inorder(root, k, traverseData);
        return traverseData.result;
    }

    private void inorder(TreeNode root, int k, TraverseData traverseData) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, traverseData);
        traverseData.nodeOrder++;
        if (traverseData.nodeOrder == k) {
            traverseData.result = root.val;
            return;
        }
        inorder(root.right, k, traverseData);
    }

    // Time O(n)
    // Space O(n)
    public int kthSmallestIterative(TreeNode root, int k) {
        int nodeOrder = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // Traverse left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Pop the top node from the stack
            current = stack.pop();
            // Decrement k by 1
            nodeOrder++;
            // If k is 0, we have found the kth smallest element
            if (nodeOrder == k) {
                return current.val;
            }
            // Otherwise, set current to the right child of the popped node
            current = current.right;
        }
        return -1;
    }

    private static class TraverseData {
        int nodeOrder;
        int result;
    }

}
